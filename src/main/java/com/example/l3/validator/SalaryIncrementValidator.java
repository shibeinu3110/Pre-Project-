package com.example.l3.validator;

import com.example.l3.commons.exception.ErrorMessages;
import com.example.l3.commons.exception.OctException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import static com.example.l3.consts.ConstParameter.EMPTY_INDEX;
import static com.example.l3.consts.StoredProcedureConst.Parameter;
import static com.example.l3.consts.StoredProcedureConst.SalaryIncrement;

@Component
@RequiredArgsConstructor
public class SalaryIncrementValidator {
    private final EntityManager entityManager;

    public void checkExistSalaryIncrement(Long id) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(SalaryIncrement.EXIST_SALARY_INCREMENT_BY_ID)
                .registerStoredProcedureParameter(Parameter.SALARY_INCREMENT_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.SALARY_INCREMENT_ID, id);
        Number result = (Number) query.getSingleResult();
        if (ObjectUtils.isEmpty(result) || result.intValue() == EMPTY_INDEX) {
            throw new OctException(ErrorMessages.NOT_FOUND, "can't find salary increment with id:" + id);
        }
    }
}
