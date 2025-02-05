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

import static com.example.l3.consts.StoredProcedureConst.*;
import static com.example.l3.consts.ConstParameter.*;
@Component
@RequiredArgsConstructor
public class PromotionValidator {
    private final EntityManager entityManager;

    public void checkExistPromotion(Long id) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(Promotion.EXIST_PROMOTION_BY_ID)
                .registerStoredProcedureParameter(Parameter.PROMOTION_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.PROMOTION_ID, id);
        Number result = (Number) query.getSingleResult();
        if(ObjectUtils.isEmpty(result) || result.intValue() == EMPTY_INDEX) {
            throw new OctException(ErrorMessages.NOT_FOUND,"can't find promotion with id:" + id);
        }
    }
}
