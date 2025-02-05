package com.example.l3.validator;

import com.example.l3.commons.exception.ErrorMessages;
import com.example.l3.commons.exception.OctException;
import com.example.l3.consts.StoredProcedureConst;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import static com.example.l3.consts.ConstParameter.EMPTY_INDEX;

@Component
@RequiredArgsConstructor
public class RegistrationValidator {
    private final EntityManager entityManager;
    public void checkExistRegistration(Long id) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(StoredProcedureConst.Registration.EXIST_REGISTRATION_BY_ID)
                .registerStoredProcedureParameter(StoredProcedureConst.Parameter.REGISTRATION_ID, Long.class, ParameterMode.IN)
                .setParameter(StoredProcedureConst.Parameter.REGISTRATION_ID, id);
        Number result = (Number) query.getSingleResult();
        if(ObjectUtils.isEmpty(result) || result.intValue() == EMPTY_INDEX) {
            throw new OctException(ErrorMessages.NOT_FOUND,"can't find registration with id: " + id);
        }
    }
}
