package com.example.l3.service.impl;

import com.example.l3.dto.RoleDto;
import com.example.l3.service.RoleService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.example.l3.consts.StoredProcedureConst.Mapper.ROLE_DTO_MAPPER;
import static com.example.l3.consts.StoredProcedureConst.Parameter.ROLE_ID;
import static com.example.l3.consts.StoredProcedureConst.Role.GET_ROLE_BY_ID;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImpl implements RoleService {
    private final EntityManager entityManager;

    @Override
    public RoleDto getRoleById(Long id) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(GET_ROLE_BY_ID, ROLE_DTO_MAPPER)
                .registerStoredProcedureParameter(ROLE_ID, Long.class, ParameterMode.IN)
                .setParameter(ROLE_ID, id);

        return (RoleDto) query.getSingleResult();

    }
}