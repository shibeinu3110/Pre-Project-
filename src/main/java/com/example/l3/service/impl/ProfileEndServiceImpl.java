package com.example.l3.service.impl;

import com.example.l3.consts.Status;
import com.example.l3.dto.ProfileEndDto;
import com.example.l3.helper.JsonHelper;
import com.example.l3.service.ProfileEndService;
import com.example.l3.validator.AuthenticationValidator;
import com.example.l3.validator.ProfileEndValidator;
import com.example.l3.validator.RegistrationValidator;
import com.example.l3.validator.StatusValidator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.example.l3.consts.StoredProcedureConst.*;

@Service
@RequiredArgsConstructor
public class ProfileEndServiceImpl implements ProfileEndService {
    private final EntityManager entityManager;
    private final ProfileEndValidator profileEndValidator;
    private final AuthenticationValidator authenticationValidator;
    private final StatusValidator statusValidator;
    private final RegistrationValidator registrationValidator;

    @Override
    public ProfileEndDto createProfileEnd(ProfileEndDto profileEndDto) {
        profileEndValidator.checkValidStorageNumberForCreate(profileEndDto.getStorageNumber());
        registrationValidator.checkExistRegistration(profileEndDto.getRegistrationId());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        profileEndDto.setEndBy(authentication.getName());
        profileEndDto.setEndDate(LocalDate.now());
        profileEndDto.setStatus(Status.CREATED.getValue());

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(ProfileEnd.CREATE_PROFILE_END, Mapper.PROFILE_END_DTO_MAPPER)
                .registerStoredProcedureParameter(Parameter.PROFILE_END_JSON, String.class, ParameterMode.IN)
                .setParameter(Parameter.PROFILE_END_JSON, JsonHelper.toJson(profileEndDto));
        return (ProfileEndDto) query.getSingleResult();
    }

    @Override
    public ProfileEndDto getProfileEndById(Long id) {
        profileEndValidator.checkExistProfileEnd(id);
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(ProfileEnd.GET_PROFILE_END_BY_ID, Mapper.PROFILE_END_DTO_MAPPER)
                .registerStoredProcedureParameter(Parameter.PROFILE_END_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.PROFILE_END_ID, id);
        return (ProfileEndDto) query.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ProfileEndDto> getAllProfileEnd() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(ProfileEnd.GET_ALL_PROFILE_END, Mapper.PROFILE_END_DTO_MAPPER);
        return mapObjectListToProfileEndLis(query.getResultList());
    }

    @Override
    public void deleteProfileEndById(Long id) {
        ProfileEndDto profileEndDto = getProfileEndById(id);
        authenticationValidator.checkCreateByManager(profileEndDto.getEndBy());
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(ProfileEnd.DELETE_PROFILE_END_BY_ID)
                .registerStoredProcedureParameter(Parameter.PROFILE_END_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.PROFILE_END_ID, id);
        query.execute();
    }

    @Override
    public ProfileEndDto updateProfileEnd(Long id, ProfileEndDto profileEndDto) {
        ProfileEndDto currentProfileEnd = getProfileEndById(id);

        registrationValidator.checkExistRegistration(profileEndDto.getRegistrationId());
        profileEndValidator.checkValidStorageNumberForUpdate(currentProfileEnd, profileEndDto);
        statusValidator.checkValidStatusForManagerUpdate(currentProfileEnd.getStatus());
        authenticationValidator.checkCreateByManager(currentProfileEnd.getEndBy());
        profileEndDto.setStatus(Status.UPDATED.getValue());

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(ProfileEnd.UPDATE_PROFILE_END_BY_MANAGER, Mapper.PROFILE_END_DTO_MAPPER)
                .registerStoredProcedureParameter(Parameter.PROFILE_END_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.PROFILE_END_ID, id)
                .registerStoredProcedureParameter(Parameter.PROFILE_END_JSON, String.class, ParameterMode.IN)
                .setParameter(Parameter.PROFILE_END_JSON, JsonHelper.toJson(profileEndDto));
        query.execute();
        return getProfileEndById(id);
    }

    @Override
    public ProfileEndDto submitProfileEnd(Long id, ProfileEndDto profileEndDto) {
        ProfileEndDto currentProfileEnd = getProfileEndById(id);
        statusValidator.checkValidStatusForMangerSubmit(currentProfileEnd.getStatus());
        authenticationValidator.checkCreateByManager(currentProfileEnd.getEndBy());
        authenticationValidator.checkExistLeader(profileEndDto.getLeaderId());

        profileEndDto.setStatus(Status.PENDING.getValue());
        profileEndDto.setSubmitDate(LocalDate.now());

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(ProfileEnd.SUBMIT_PROFILE_END, Mapper.PROFILE_END_DTO_MAPPER)
                .registerStoredProcedureParameter(Parameter.PROFILE_END_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.PROFILE_END_ID, id)
                .registerStoredProcedureParameter(Parameter.PROFILE_END_JSON, String.class, ParameterMode.IN)
                .setParameter(Parameter.PROFILE_END_JSON, JsonHelper.toJson(profileEndDto));
        query.execute();
        return getProfileEndById(id);
    }

    @Override
    public ProfileEndDto updateProfileEndByLeader(Long id, ProfileEndDto profileEndDto) {
        ProfileEndDto currentProfileEnd = getProfileEndById(id);

        statusValidator.checkValidStatusForLeaderUpdate(currentProfileEnd.getStatus());
        statusValidator.checkValidStatusForLeader(profileEndDto.getStatus());
        authenticationValidator.checkIsForLeader(currentProfileEnd.getLeaderId());

        if (profileEndDto.getStatus().equalsIgnoreCase(Status.ACCEPTED.getValue())) {
            profileEndDto.setStatus(Status.ACCEPTED.getValue());
            profileEndDto.setAcceptDate(LocalDate.now());
        } else if (profileEndDto.getStatus().equalsIgnoreCase(Status.REJECTED.getValue())) {
            profileEndDto.setStatus(Status.REJECTED.getValue());
            profileEndDto.setRejectDate(LocalDate.now());
        } else if (profileEndDto.getStatus().equalsIgnoreCase(Status.ADDITIONAL.getValue())) {
            profileEndDto.setStatus(Status.ADDITIONAL.getValue());
            profileEndDto.setAdditionalDate(LocalDate.now());
        }

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(ProfileEnd.UPDATE_PROFILE_END_BY_LEADER, Mapper.PROFILE_END_DTO_MAPPER)
                .registerStoredProcedureParameter(Parameter.PROFILE_END_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.PROFILE_END_ID, id)
                .registerStoredProcedureParameter(Parameter.PROFILE_END_JSON, String.class, ParameterMode.IN)
                .setParameter(Parameter.PROFILE_END_JSON, JsonHelper.toJson(profileEndDto));
        query.execute();
        return getProfileEndById(id);
    }


    private List<ProfileEndDto> mapObjectListToProfileEndLis(List<Object> objectList) {
        List<ProfileEndDto> profileEndDtoList = new ArrayList<>();
        for (Object object : objectList) {
            if (object instanceof ProfileEndDto) {
                profileEndDtoList.add((ProfileEndDto) object);
            }
        }
        return profileEndDtoList;
    }
}
