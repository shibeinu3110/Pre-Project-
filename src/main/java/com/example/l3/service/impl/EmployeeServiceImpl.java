package com.example.l3.service.impl;

import com.example.l3.commons.exception.ErrorMessages;
import com.example.l3.commons.exception.OctException;
import com.example.l3.dto.EmployeeDto;
import com.example.l3.helper.JsonHelper;
import com.example.l3.service.EmployeeService;
import com.example.l3.service.MinioService;
import com.example.l3.validator.EmployeeValidator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

import static com.example.l3.consts.StoredProcedureConst.Employee.*;
import static com.example.l3.consts.StoredProcedureConst.Parameter.*;
import static com.example.l3.consts.StoredProcedureConst.Mapper.EMPLOYEE_DTO_MAPPER;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    private final EntityManager entityManager;
    private final MinioService minioService;
    private final EmployeeValidator employeeValidator;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto, MultipartFile multipartFile) {
        this.employeeValidator.checkEmployee(employeeDto);
        try {
            employeeDto.setImageUrl(minioService.uploadImage(multipartFile));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        employeeDto.setManagerCreated(authentication.getName());
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(CREATE_EMPLOYEE, EMPLOYEE_DTO_MAPPER)
                .registerStoredProcedureParameter(EMPLOYEE_JSON, String.class, ParameterMode.IN)
                .setParameter(EMPLOYEE_JSON, JsonHelper.toJson(employeeDto));
        query.execute();
        return employeeDto;

    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        employeeValidator.existById(employeeId);
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(GET_EMPLOYEE_BY_ID, EMPLOYEE_DTO_MAPPER)
                .registerStoredProcedureParameter(EMPLOYEE_ID, Long.class, ParameterMode.IN)
                .setParameter(EMPLOYEE_ID, employeeId);
        Object result = query.getSingleResult();

        return (EmployeeDto) result;
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        EmployeeDto employeeDto = getEmployeeById(employeeId);
        String imageUrl = employeeDto.getImageUrl();
        try {
            minioService.deleteImage(imageUrl);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(DELETE_EMPLOYEE_BY_ID)
                .registerStoredProcedureParameter(EMPLOYEE_ID, Long.class, ParameterMode.IN)
                .setParameter(EMPLOYEE_ID, employeeId);

        query.execute();
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto, MultipartFile file) {
        EmployeeDto existedEmployee = getEmployeeById(employeeId);
        employeeValidator.checkUpdateEmployee(employeeDto, existedEmployee);

        employeeDto.setEmployeeId(employeeId);


        //handle image
        String oldImageUrl = existedEmployee.getImageUrl();
        try {
            minioService.deleteImage(oldImageUrl);
        } catch (Exception e) {
            throw new OctException(ErrorMessages.NOT_FOUND, "can't find image with url: " + oldImageUrl);
        }

        String newImageUrl;
        try {
            newImageUrl = minioService.uploadImage(file);
        } catch (Exception e) {
            throw new OctException(ErrorMessages.NOT_ALLOW_UPDATE, "can't upload image");
        }
        employeeDto.setImageUrl(newImageUrl);

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(UPDATE_EMPLOYEE, EMPLOYEE_DTO_MAPPER)
                .registerStoredProcedureParameter(EMPLOYEE_ID, Long.class, ParameterMode.IN)
                .setParameter(EMPLOYEE_ID, employeeId)
                .registerStoredProcedureParameter(EMPLOYEE_JSON, String.class, ParameterMode.IN)
                .setParameter(EMPLOYEE_JSON, JsonHelper.toJson(employeeDto));
        query.execute();
        return getEmployeeById(employeeId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<EmployeeDto> getAllEmployee() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(GET_ALL_EMPLOYEE, EMPLOYEE_DTO_MAPPER);

        return mapObjectListToEmployeeList(query.getResultList());
    }

    private List<EmployeeDto> mapObjectListToEmployeeList(List<Object> objectList) {
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        for (Object object : objectList) {
            if (object instanceof EmployeeDto) {
                employeeDtoList.add((EmployeeDto) object);
            }
        }
        return employeeDtoList;
    }


}
