package com.example.l3.service.impl;

import com.example.l3.dto.CertificateDto;
import com.example.l3.dto.RelationshipDto;
import com.example.l3.helper.JsonHelper;
import com.example.l3.service.RelationshipService;
import com.example.l3.validator.EmployeeValidator;
import com.example.l3.validator.RelationshipValidator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.example.l3.consts.StoredProcedureConst.*;

@Service
@RequiredArgsConstructor
public class RelationshipServiceImpl implements RelationshipService {
    private final EntityManager entityManager;
    private final EmployeeValidator employeeValidator;
    private final RelationshipValidator relationshipValidator;
    @Override
    public RelationshipDto createRelationship(RelationshipDto relationshipDto) {
        employeeValidator.existById(relationshipDto.getEmployeeId());
        relationshipValidator.checkValidRelationship(relationshipDto);

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(Relationship.CREATE_RELATIONSHIP, Mapper.RELATIONSHIP_DTO_MAPPER)
                .registerStoredProcedureParameter(Parameter.RELATIONSHIP_JSON, String.class, ParameterMode.IN)
                .setParameter(Parameter.RELATIONSHIP_JSON, JsonHelper.toJson(relationshipDto));


        return (RelationshipDto) query.getSingleResult();
    }

    @Override
    public RelationshipDto getRelationShipById(Long id) {
        relationshipValidator.existById(id);
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(Relationship.GET_RELATIONSHIP_BY_ID, Mapper.RELATIONSHIP_DTO_MAPPER)
                .registerStoredProcedureParameter(Parameter.RELATIONSHIP_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.RELATIONSHIP_ID, id);


        return (RelationshipDto) query.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<RelationshipDto> getRelationshipsByEmployeeId(Long id) {
        employeeValidator.existById(id);
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(Relationship.GET_RELATIONSHIP_BY_EMPLOYEE_ID, Mapper.RELATIONSHIP_DTO_MAPPER)
                .registerStoredProcedureParameter(Parameter.EMPLOYEE_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.EMPLOYEE_ID, id);

        return mapObjectToRelationship(query.getResultList());
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<RelationshipDto> getAllRelationship() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(Relationship.GET_ALL_RELATIONSHIP, Mapper.RELATIONSHIP_DTO_MAPPER);
        return mapObjectToRelationship(query.getResultList());
    }

    @Override
    public void deleteById(Long id) {
        relationshipValidator.existById(id);
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(Relationship.DELETE_BY_RELATIONSHIP_BY_ID)
                .registerStoredProcedureParameter(Parameter.RELATIONSHIP_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.RELATIONSHIP_ID, id);
        query.execute();
    }

    @Override
    public RelationshipDto updateRelationship(Long id, RelationshipDto relationshipDto) {
        relationshipValidator.checkRelationshipForUpdate(relationshipDto, getRelationShipById(id));
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(Relationship.UPDATE_RELATIONSHIP, Mapper.RELATIONSHIP_DTO_MAPPER)
                .registerStoredProcedureParameter(Parameter.RELATIONSHIP_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.RELATIONSHIP_ID, id)
                .registerStoredProcedureParameter(Parameter.RELATIONSHIP_JSON, String.class, ParameterMode.IN)
                .setParameter(Parameter.RELATIONSHIP_JSON, JsonHelper.toJson(relationshipDto));

        query.execute();

        return getRelationShipById(id);
    }

    private List<RelationshipDto> mapObjectToRelationship(List<Object> objectList) {
        List<RelationshipDto> relationshipDtoList = new ArrayList<>();
        for(Object object : objectList) {
            if(object instanceof RelationshipDto) {
                relationshipDtoList.add((RelationshipDto) object);
            }
        }
        return relationshipDtoList;
    }
}
