package com.example.l3.validator;

import com.example.l3.commons.exception.ErrorMessages;
import com.example.l3.commons.exception.OctException;
import com.example.l3.dto.UserDto;
import com.example.l3.security.MyUserDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import static com.example.l3.consts.ConstParameter.EMPTY_INDEX;
import static com.example.l3.consts.StoredProcedureConst.*;

@Component
@RequiredArgsConstructor
@Slf4j
public class AuthenticationValidator {
    private final EntityManager entityManager;
    public void checkCreateByManager(String createBy) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!authentication.getName().equals(createBy)) {
            throw new OctException(ErrorMessages.NOT_ALLOW, "manager " + authentication.getName() +
                    " didn't create this chart");
        }
    }

    public void checkExistLeader(Long id) {
        log.info("check " + id);
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(Authenticator.EXIST_LEADER_BY_ID)
                .registerStoredProcedureParameter(Parameter.USER_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.USER_ID, id);

        Number result = (Number) query.getSingleResult();
        if(ObjectUtils.isEmpty(result) || result.intValue() == EMPTY_INDEX) {
            throw new OctException(ErrorMessages.NOT_FOUND,"can't find leader with id:" + id);
        }
    }

    public void checkIsForLeader(Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long leaderId = ((MyUserDetails) authentication.getPrincipal()).getUserDto().getId();
        if(!leaderId.equals(id)) {
            throw new OctException(ErrorMessages.NOT_ALLOW_LEADER);
        }
    }
}
