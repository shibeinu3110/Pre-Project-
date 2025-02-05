package com.example.l3.validator;

import com.example.l3.commons.exception.ErrorMessages;
import com.example.l3.commons.exception.OctException;
import com.example.l3.consts.ConstParameter;
import com.example.l3.dto.RelationshipDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.regex.Pattern;

import static com.example.l3.consts.ConstParameter.EMPTY_INDEX;
import static com.example.l3.consts.ConstParameter.POSTCODE_REGEX;
import static com.example.l3.consts.StoredProcedureConst.*;
import static com.example.l3.consts.StoredProcedureConst.Employee.EXIST_EMPLOYEE_BY_POSTCODE;
import static com.example.l3.consts.StoredProcedureConst.Parameter.POSTCODE;

@Component
@RequiredArgsConstructor
public class RelationshipValidator {
    private final EntityManager entityManager;

    public void checkValidRelationship(RelationshipDto relationshipDto) {
        checkPostcodeFormat(relationshipDto.getPostcode());
        if(checkDuplicatePostcode(relationshipDto.getPostcode())) {
            throw new OctException(ErrorMessages.DUPLICATE, "duplicate postcode");
        }
    }

    public void checkRelationshipForUpdate(RelationshipDto relationship, RelationshipDto currentRelationship) {
        checkPostcodeFormat(relationship.getPostcode());
        if(!relationship.getPostcode().equals(currentRelationship.getPostcode()) && checkDuplicatePostcode(relationship.getPostcode())) {
            throw new OctException(ErrorMessages.DUPLICATE, "postcode already exist");
        }
    }

    public void existById(Long id) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(Relationship.EXIST_RELATIONSHIP_BY_ID)
                .registerStoredProcedureParameter(Parameter.RELATIONSHIP_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.RELATIONSHIP_ID, id);

        Number result = (Number) query.getSingleResult();
        if( ObjectUtils.isEmpty(result) || result.intValue() == EMPTY_INDEX) {
            throw new OctException(ErrorMessages.NOT_FOUND, "can't find relationship with id: " + id);
        }
    }

    private void checkPostcodeFormat(String postcode) {
        if (!Pattern.matches(POSTCODE_REGEX, postcode)) {
            throw new OctException(ErrorMessages.INVALID_FORMAT, "invalid postcode format");
        }
    }

    private boolean checkDuplicatePostcode(String postcode){
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(Relationship.EXIST_RELATIONSHIP_BY_POSTCODE)
                .registerStoredProcedureParameter(POSTCODE, String.class, ParameterMode.IN)
                .setParameter(POSTCODE, postcode);

        Number result = (Number) query.getSingleResult();

        return !ObjectUtils.isEmpty(result) && result.intValue() >= ConstParameter.EXIST_INDEX;
    }


}
