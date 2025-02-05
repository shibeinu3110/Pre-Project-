package com.example.l3.service.impl;

import com.example.l3.consts.Status;
import com.example.l3.dto.ProposalAdviceDto;
import com.example.l3.dto.RegistrationDto;
import com.example.l3.helper.JsonHelper;
import com.example.l3.service.RegistrationService;
import com.example.l3.validator.AuthenticationValidator;
import com.example.l3.validator.EmployeeValidator;
import com.example.l3.validator.RegistrationValidator;
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
public class RegistrationServiceImpl implements RegistrationService {
    private final EntityManager entityManager;
    private final EmployeeValidator employeeValidator;
    private final RegistrationValidator registrationValidator;
    private final AuthenticationValidator authenticationValidator;
    private final StatusValidator statusValidator;

    @Override
    public RegistrationDto createRegistration(RegistrationDto registrationDto) {
        employeeValidator.existById(registrationDto.getEmployeeId());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        registrationDto.setCreatedBy(authentication.getName());
        registrationDto.setCreateDate(LocalDate.now());
        registrationDto.setStatus(Status.CREATED.getValue());

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(Registration.CREATE_REGISTRATION, Mapper.REGISTRATION_DTO_MAPPER)
                .registerStoredProcedureParameter(Parameter.REGISTRATION_JSON, String.class, ParameterMode.IN)
                .setParameter(Parameter.REGISTRATION_JSON, JsonHelper.toJson(registrationDto));
        return (RegistrationDto) query.getSingleResult();
    }

    @Override
    public RegistrationDto getRegistrationById(Long id) {
        registrationValidator.checkExistRegistration((id));
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(Registration.GET_REGISTRATION_BY_ID, Mapper.REGISTRATION_DTO_MAPPER)
                .registerStoredProcedureParameter(Parameter.REGISTRATION_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.REGISTRATION_ID, id);
        return (RegistrationDto) query.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<RegistrationDto> getAllRegistration() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(Registration.GET_ALL_REGISTRATION, Mapper.REGISTRATION_DTO_MAPPER);

        return mapObjectListToRegistrationList(query.getResultList());
    }

    @Override
    public void deleteRegistrationById(Long id) {
        RegistrationDto registrationDto = getRegistrationById(id);
        authenticationValidator.checkCreateByManager(registrationDto.getCreatedBy());

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(Registration.DELETE_REGISTRATION_BY_ID)
                .registerStoredProcedureParameter(Parameter.REGISTRATION_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.REGISTRATION_ID, id);
        query.execute();
    }

    @Override
    public RegistrationDto updateRegistration(Long id, RegistrationDto registrationDto) {
        RegistrationDto currentRegistration = getRegistrationById(id);

        authenticationValidator.checkCreateByManager(currentRegistration.getCreatedBy());
        statusValidator.checkValidStatusForManagerUpdate(currentRegistration.getStatus());
        registrationDto.setStatus(Status.UPDATED.getValue());
        employeeValidator.existById(registrationDto.getEmployeeId());

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(Registration.UPDATE_REGISTRATION_BY_MANAGER, Mapper.REGISTRATION_DTO_MAPPER)
                .registerStoredProcedureParameter(Parameter.REGISTRATION_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.REGISTRATION_ID, id)
                .registerStoredProcedureParameter(Parameter.REGISTRATION_JSON, String.class, ParameterMode.IN)
                .setParameter(Parameter.REGISTRATION_JSON, JsonHelper.toJson(registrationDto));
        query.execute();
        return getRegistrationById(id);
    }

    @Override
    public RegistrationDto submitRegistration(Long id, RegistrationDto registrationDto) {
        log.info(registrationDto.getLeaderId().toString());

        RegistrationDto currentRegistration = getRegistrationById(id);

        authenticationValidator.checkCreateByManager(currentRegistration.getCreatedBy());
        statusValidator.checkValidStatusForMangerSubmit(currentRegistration.getStatus());
        authenticationValidator.checkExistLeader(registrationDto.getLeaderId());

        registrationDto.setStatus(Status.PENDING.getValue());
        registrationDto.setSubmitDate(LocalDate.now());


        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(Registration.SUBMIT_REGISTRATION, Mapper.REGISTRATION_DTO_MAPPER)
                .registerStoredProcedureParameter(Parameter.REGISTRATION_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.REGISTRATION_ID, id)
                .registerStoredProcedureParameter(Parameter.REGISTRATION_JSON, String.class, ParameterMode.IN)
                .setParameter(Parameter.REGISTRATION_JSON, JsonHelper.toJson(registrationDto));
        query.execute();
        return getRegistrationById(id);
    }

    @Override
    public RegistrationDto updateRegistrationByLeader(Long id, RegistrationDto registrationDto) {
        RegistrationDto currentRegistration = getRegistrationById(id);

        authenticationValidator.checkIsForLeader(currentRegistration.getLeaderId());
        statusValidator.checkValidStatusForLeaderUpdate(currentRegistration.getStatus());
        statusValidator.checkValidStatusForLeader(registrationDto.getStatus());

        if (registrationDto.getStatus().equalsIgnoreCase(Status.ACCEPTED.getValue())) {
            registrationDto.setStatus(Status.ACCEPTED.getValue());
            registrationDto.setAcceptDate(LocalDate.now());
        } else if (registrationDto.getStatus().equalsIgnoreCase(Status.REJECTED.getValue())) {
            registrationDto.setStatus(Status.REJECTED.getValue());
            registrationDto.setRejectDate(LocalDate.now());
        } else if (registrationDto.getStatus().equalsIgnoreCase(Status.ADDITIONAL.getValue())) {
            registrationDto.setStatus(Status.ADDITIONAL.getValue());
            registrationDto.setAdditionalDate(LocalDate.now());
        }



        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(Registration.UPDATE_REGISTRATION_BY_LEADER, Mapper.PROPOSAL_ADVICE_DTO_MAPPER)
                .registerStoredProcedureParameter(Parameter.REGISTRATION_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.REGISTRATION_ID, id)
                .registerStoredProcedureParameter(Parameter.REGISTRATION_JSON, String.class, ParameterMode.IN)
                .setParameter(Parameter.REGISTRATION_JSON, JsonHelper.toJson(registrationDto));
        query.execute();
        return getRegistrationById(id);
    }

    private List<RegistrationDto> mapObjectListToRegistrationList(List<Object> objectList) {
        List<RegistrationDto> registrationDtoList = new ArrayList<>();
        for(Object object : objectList) {
            if(object instanceof RegistrationDto) {
                registrationDtoList.add((RegistrationDto) object);
            }
        }
        return registrationDtoList;
    }

}
