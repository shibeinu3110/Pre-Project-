package com.example.l3.validator;

import com.example.l3.commons.exception.ErrorMessages;
import com.example.l3.commons.exception.OctException;
import com.example.l3.dto.ProfileEndDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import static com.example.l3.consts.ConstParameter.EMPTY_INDEX;
import static com.example.l3.consts.StoredProcedureConst.*;

@Component
@RequiredArgsConstructor
public class ProfileEndValidator {
    private final EntityManager entityManager;
    public void checkExistProfileEnd(Long id) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(ProfileEnd.EXIST_PROFILE_END_BY_ID)
                .registerStoredProcedureParameter(Parameter.PROFILE_END_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.PROFILE_END_ID, id);

        Number result = (Number) query.getSingleResult();
        if (result.intValue() == EMPTY_INDEX || ObjectUtils.isEmpty(result)) {
            throw new OctException(ErrorMessages.NOT_FOUND, "can't find profile end with id: " + id);
        }
    }

    public void checkValidStorageNumberForUpdate(ProfileEndDto currentProfileEndDto, ProfileEndDto profileEnd) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(ProfileEnd.EXIST_PROFILE_END_BY_STORAGE_NUMBER)
                .registerStoredProcedureParameter(Parameter.STORAGE_NUMBER, Long.class, ParameterMode.IN)
                .setParameter(Parameter.STORAGE_NUMBER, profileEnd.getStorageNumber());
        Number result = (Number) query.getSingleResult();

        if((!currentProfileEndDto.getStorageNumber().equals(profileEnd.getStorageNumber())) && (result.intValue() != EMPTY_INDEX)) {
            throw new OctException(ErrorMessages.DUPLICATE, "storage number: " + profileEnd.getStorageNumber() + " already exists");
        }
    }
    public void checkValidStorageNumberForCreate(Long storageNumber) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(ProfileEnd.EXIST_PROFILE_END_BY_STORAGE_NUMBER)
                .registerStoredProcedureParameter(Parameter.STORAGE_NUMBER, Long.class, ParameterMode.IN)
                .setParameter(Parameter.STORAGE_NUMBER, storageNumber);
        Number result = (Number) query.getSingleResult();

        if(result.intValue() != EMPTY_INDEX) {
            throw new OctException(ErrorMessages.DUPLICATE, "storage number: " + storageNumber + " already exists");
        }
    }
}
