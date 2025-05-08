package com.example.l3.service.impl;

import com.example.l3.consts.Status;
import com.example.l3.dto.SalaryIncrementDto;
import com.example.l3.helper.JsonHelper;
import com.example.l3.service.SalaryIncrementService;
import com.example.l3.validator.AuthenticationValidator;
import com.example.l3.validator.EmployeeValidator;
import com.example.l3.validator.SalaryIncrementValidator;
import com.example.l3.validator.StatusValidator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.example.l3.consts.StoredProcedureConst.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class SalaryIncrementServiceImpl implements SalaryIncrementService {
    private final EntityManager entityManager;
    private final EmployeeValidator employeeValidator;
    private final SalaryIncrementValidator salaryIncrementValidator;
    private final AuthenticationValidator authenticationValidator;
    private final StatusValidator statusValidator;

    @Override
    public SalaryIncrementDto createSalaryIncrement(SalaryIncrementDto salaryIncrementDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //validate
        employeeValidator.existById(salaryIncrementDto.getEmployeeId());

        //set value
        salaryIncrementDto.setCreateDate(LocalDate.now());
        salaryIncrementDto.setCreatedBy(authentication.getName());
        salaryIncrementDto.setStatus(Status.CREATED.getValue());

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(SalaryIncrement.CREATE_SALARY_INCREMENT, Mapper.SALARY_INCREMENT_DTO_MAPPER)
                .registerStoredProcedureParameter(Parameter.SALARY_INCREMENT_JSON, String.class, ParameterMode.IN)
                .setParameter(Parameter.SALARY_INCREMENT_JSON, JsonHelper.toJson(salaryIncrementDto));

        return (SalaryIncrementDto) query.getSingleResult();
    }

    @Override
    public SalaryIncrementDto getSalaryIncrementById(Long id) {
        salaryIncrementValidator.checkExistSalaryIncrement(id);
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(SalaryIncrement.GET_SALARY_INCREMENT_BY_ID, Mapper.SALARY_INCREMENT_DTO_MAPPER)
                .registerStoredProcedureParameter(Parameter.SALARY_INCREMENT_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.SALARY_INCREMENT_ID, id);
        return (SalaryIncrementDto) query.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SalaryIncrementDto> getAllSalaryIncrement() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(SalaryIncrement.GET_ALL_SALARY_INCREMENT, Mapper.SALARY_INCREMENT_DTO_MAPPER);

        return mapObjectListToSalaryIncrementList(query.getResultList());
    }

    @Override
    public void deleteSalaryIncrementById(Long id) {
        salaryIncrementValidator.checkExistSalaryIncrement(id);
        authenticationValidator.checkCreateByManager(getSalaryIncrementById(id).getCreatedBy());

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(SalaryIncrement.DELETE_SALARY_INCREMENT_BY_ID)
                .registerStoredProcedureParameter(Parameter.SALARY_INCREMENT_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.SALARY_INCREMENT_ID, id);
        query.execute();

    }


    //manager update
    @Override
    public SalaryIncrementDto updateSalaryIncrement(Long id, SalaryIncrementDto salaryIncrementDto) {

        SalaryIncrementDto currentSalaryIncrement = getSalaryIncrementById(id);
        employeeValidator.existById(salaryIncrementDto.getEmployeeId());
        authenticationValidator.checkCreateByManager(currentSalaryIncrement.getCreatedBy());
        statusValidator.checkValidStatusForManagerUpdate(currentSalaryIncrement.getStatus());
        salaryIncrementDto.setStatus(Status.UPDATED.getValue());

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(SalaryIncrement.UPDATE_SALARY_INCREMENT_BY_MANAGER, Mapper.SALARY_INCREMENT_DTO_MAPPER)
                .registerStoredProcedureParameter(Parameter.SALARY_INCREMENT_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.SALARY_INCREMENT_ID, id)
                .registerStoredProcedureParameter(Parameter.SALARY_INCREMENT_JSON, String.class, ParameterMode.IN)
                .setParameter(Parameter.SALARY_INCREMENT_JSON, JsonHelper.toJson(salaryIncrementDto));

        query.execute();
        return getSalaryIncrementById(id);
    }

    @Override
    public SalaryIncrementDto submitSalaryIncrement(Long id, SalaryIncrementDto salaryIncrementDto) {
        SalaryIncrementDto currentSalaryIncrement = getSalaryIncrementById(id);
        authenticationValidator.checkCreateByManager(currentSalaryIncrement.getCreatedBy());
        statusValidator.checkValidStatusForMangerSubmit(currentSalaryIncrement.getStatus());
        authenticationValidator.checkExistLeader(salaryIncrementDto.getLeaderId());
        salaryIncrementDto.setStatus(Status.PENDING.getValue());
        salaryIncrementDto.setSubmitDate(LocalDate.now());

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(SalaryIncrement.SUBMIT_SALARY_INCREMENT, Mapper.SALARY_INCREMENT_DTO_MAPPER)
                .registerStoredProcedureParameter(Parameter.SALARY_INCREMENT_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.SALARY_INCREMENT_ID, id)
                .registerStoredProcedureParameter(Parameter.SALARY_INCREMENT_JSON, String.class, ParameterMode.IN)
                .setParameter(Parameter.SALARY_INCREMENT_JSON, JsonHelper.toJson(salaryIncrementDto));
        query.execute();
        return getSalaryIncrementById(id);
    }

    @Override
    public SalaryIncrementDto updateSalaryIncrementByLeader(Long id, SalaryIncrementDto salaryIncrementDto) {
        SalaryIncrementDto currentSalaryIncrement = getSalaryIncrementById(id);
        statusValidator.checkValidStatusForLeaderUpdate(currentSalaryIncrement.getStatus());
        statusValidator.checkValidStatusForLeader(salaryIncrementDto.getStatus());
        authenticationValidator.checkIsForLeader(currentSalaryIncrement.getLeaderId());

        if (salaryIncrementDto.getStatus().equalsIgnoreCase(Status.ACCEPTED.getValue())) {
            salaryIncrementDto.setStatus(Status.ACCEPTED.getValue());
            salaryIncrementDto.setAcceptDate(LocalDate.now());
        } else if (salaryIncrementDto.getStatus().equalsIgnoreCase(Status.REJECTED.getValue())) {
            salaryIncrementDto.setStatus(Status.REJECTED.getValue());
            salaryIncrementDto.setRejectDate(LocalDate.now());
        } else if (salaryIncrementDto.getStatus().equalsIgnoreCase(Status.ADDITIONAL.getValue())) {
            salaryIncrementDto.setStatus(Status.ADDITIONAL.getValue());
            salaryIncrementDto.setAdditionalDate(LocalDate.now());
        }

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(SalaryIncrement.UPDATE_SALARY_INCREMENT_BY_LEADER, Mapper.SALARY_INCREMENT_DTO_MAPPER)
                .registerStoredProcedureParameter(Parameter.SALARY_INCREMENT_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.SALARY_INCREMENT_ID, id)
                .registerStoredProcedureParameter(Parameter.SALARY_INCREMENT_JSON, String.class, ParameterMode.IN)
                .setParameter(Parameter.SALARY_INCREMENT_JSON, JsonHelper.toJson(salaryIncrementDto));

        query.execute();
        return getSalaryIncrementById(id);
    }

    private List<SalaryIncrementDto> mapObjectListToSalaryIncrementList(List<Object> objectList) {
        List<SalaryIncrementDto> salaryIncrementDtoList = new ArrayList<>();
        for (Object object : objectList) {
            if (object instanceof SalaryIncrementDto) {
                salaryIncrementDtoList.add((SalaryIncrementDto) object);
            }
        }
        return salaryIncrementDtoList;
    }
}
