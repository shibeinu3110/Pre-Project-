package com.example.l3.validator;

import com.example.l3.commons.exception.ErrorMessages;
import com.example.l3.commons.exception.OctException;
import com.example.l3.consts.ConstParameter;
import com.example.l3.dto.UserDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.regex.Pattern;

import static com.example.l3.consts.ConstParameter.PHONE_REGEX;
import static com.example.l3.consts.StoredProcedureConst.Parameter.*;
import static com.example.l3.consts.StoredProcedureConst.User.*;

@Component
@RequiredArgsConstructor
public class UserValidator {
    private final EntityManager entityManager;

    public void checkUser(UserDto userDto) {
        checkPhoneFormat(userDto.getPhone());


        if (checkDuplicateEmail(userDto.getEmail())) {
            throw new OctException(ErrorMessages.DUPLICATE, "duplicate email");
        }
        if (checkDuplicatePhone(userDto.getPhone())) {
            throw new OctException(ErrorMessages.DUPLICATE, "duplicate phone number");
        }
        if (checkDuplicateUsername(userDto.getUsername())) {
            throw new OctException(ErrorMessages.DUPLICATE, "duplicate username, username already exist");
        }
    }

    private void checkPhoneFormat(String phone) {
        if (!Pattern.matches(PHONE_REGEX, phone)) {
            throw new OctException(ErrorMessages.INVALID_FORMAT, "invalid phone format");
        }
    }

    private boolean checkDuplicateUsername(String username) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(EXIST_USER_BY_USERNAME)
                .registerStoredProcedureParameter(USERNAME, String.class, ParameterMode.IN)
                .setParameter(USERNAME, username);

        Number result = (Number) query.getSingleResult();

        return !ObjectUtils.isEmpty(result) && result.intValue() >= ConstParameter.EXIST_INDEX;
    }

    private boolean checkDuplicatePhone(String phone) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(EXIST_USER_BY_PHONE)
                .registerStoredProcedureParameter(PHONE, String.class, ParameterMode.IN)
                .setParameter(PHONE, phone);

        Number result = (Number) query.getSingleResult();

        return !ObjectUtils.isEmpty(result) && result.intValue() >= ConstParameter.EXIST_INDEX;
    }

    private boolean checkDuplicateEmail(String email) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(EXIST_USER_BY_EMAIL)
                .registerStoredProcedureParameter(EMAIL, String.class, ParameterMode.IN)
                .setParameter(EMAIL, email);

        Number result = (Number) query.getSingleResult();

        return !ObjectUtils.isEmpty(result) && result.intValue() >= ConstParameter.EXIST_INDEX;
    }


}