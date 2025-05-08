package com.example.l3.validator;

import com.example.l3.commons.exception.ErrorMessages;
import com.example.l3.commons.exception.OctException;
import com.example.l3.consts.ConstParameter;
import com.example.l3.dto.EmployeeDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.regex.Pattern;

import static com.example.l3.consts.ConstParameter.*;
import static com.example.l3.consts.StoredProcedureConst.Employee.*;
import static com.example.l3.consts.StoredProcedureConst.Parameter.*;

@Component
@RequiredArgsConstructor
public class EmployeeValidator {
    private final EntityManager entityManager;

    public void existById(Long employeeId) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(EXIST_EMPLOYEE_BY_ID)
                .registerStoredProcedureParameter(EMPLOYEE_ID, Long.class, ParameterMode.IN)
                .setParameter(EMPLOYEE_ID, employeeId);

        Number result = (Number) query.getSingleResult();

        if (ObjectUtils.isEmpty(result) || result.intValue() == EMPTY_INDEX) {
            throw new OctException(ErrorMessages.NOT_FOUND, "can't find employee with id: " + employeeId);
        }
    }

    public void checkUpdateEmployee(EmployeeDto employeeDto, EmployeeDto currentEmployee) {
        checkEmailFormat(employeeDto.getEmail());
        checkPhoneFormat(employeeDto.getPhoneNumber());
        if (!employeeDto.getPhoneNumber().equals(currentEmployee.getPhoneNumber()) && checkDuplicatePhone(employeeDto.getPhoneNumber())) {
            throw new OctException(ErrorMessages.DUPLICATE, "phone number already exist");
        }
        if (!employeeDto.getEmail().equals(currentEmployee.getEmail()) && checkDuplicatePhone(employeeDto.getEmail())) {
            throw new OctException(ErrorMessages.DUPLICATE, "email already exist");
        }
        if (!employeeDto.getPostcode().equals(currentEmployee.getPostcode()) && checkDuplicatePhone(employeeDto.getPostcode())) {
            throw new OctException(ErrorMessages.DUPLICATE, "postcode already exist");
        }
        if (!employeeDto.getEmployeeCode().equals(currentEmployee.getEmployeeCode()) && checkDuplicateEmployeeCode(employeeDto.getEmployeeCode())) {
            throw new OctException(ErrorMessages.DUPLICATE, "employee code already exist");
        }
    }


    public void checkEmployee(EmployeeDto employeeDto) {

        checkEmailFormat(employeeDto.getEmail());
        checkPhoneFormat(employeeDto.getPhoneNumber());
        checkPostcodeFormat(employeeDto.getPostcode());

        if (checkDuplicateEmail(employeeDto.getEmail())) {
            throw new OctException(ErrorMessages.DUPLICATE, "duplicate email");
        }
        if (checkDuplicatePostCode(employeeDto.getPostcode())) {
            throw new OctException(ErrorMessages.DUPLICATE, "duplicate postcode");
        }
        if (checkDuplicatePhone(employeeDto.getPhoneNumber())) {
            throw new OctException(ErrorMessages.DUPLICATE, "duplicate phone number");
        }
        if (checkDuplicateEmployeeCode(employeeDto.getEmployeeCode())) {
            throw new OctException(ErrorMessages.DUPLICATE, "duplicate employee code");
        }
    }

    private void checkPostcodeFormat(String postcode) {
        if (!Pattern.matches(POSTCODE_REGEX, postcode)) {
            throw new OctException(ErrorMessages.INVALID_FORMAT, "invalid postcode format");
        }
    }

    private void checkEmailFormat(String email) {
        if (!Pattern.matches(EMAIL_REGEX, email)) {
            throw new OctException(ErrorMessages.INVALID_FORMAT, "invalid email format");
        }
    }

    private void checkPhoneFormat(String phone) {
        if (!Pattern.matches(PHONE_REGEX, phone)) {
            throw new OctException(ErrorMessages.INVALID_FORMAT, "invalid phone format");
        }
    }


    private boolean checkDuplicateEmail(String email) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(EXIST_EMPLOYEE_BY_EMAIL)
                .registerStoredProcedureParameter(EMAIL, String.class, ParameterMode.IN)
                .setParameter(EMAIL, email);

        Number result = (Number) query.getSingleResult();

        return !ObjectUtils.isEmpty(result) && result.intValue() >= ConstParameter.EXIST_INDEX;
    }

    private boolean checkDuplicatePostCode(String postcode) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(EXIST_EMPLOYEE_BY_POSTCODE)
                .registerStoredProcedureParameter(POSTCODE, String.class, ParameterMode.IN)
                .setParameter(POSTCODE, postcode);

        Number result = (Number) query.getSingleResult();

        return !ObjectUtils.isEmpty(result) && result.intValue() >= ConstParameter.EXIST_INDEX;
    }

    private boolean checkDuplicatePhone(String phone) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(EXIST_EMPLOYEE_BY_PHONE)
                .registerStoredProcedureParameter(PHONE, String.class, ParameterMode.IN)
                .setParameter(PHONE, phone);

        Number result = (Number) query.getSingleResult();

        return !ObjectUtils.isEmpty(result) && result.intValue() >= ConstParameter.EXIST_INDEX;
    }

    private boolean checkDuplicateEmployeeCode(String employeeCode) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(EXIST_EMPLOYEE_BY_EMPLOYEE_CODE)
                .registerStoredProcedureParameter(EMPLOYEE_CODE, String.class, ParameterMode.IN)
                .setParameter(EMPLOYEE_CODE, employeeCode);

        Number result = (Number) query.getSingleResult();

        return !ObjectUtils.isEmpty(result) && result.intValue() >= ConstParameter.EXIST_INDEX;
    }
}
