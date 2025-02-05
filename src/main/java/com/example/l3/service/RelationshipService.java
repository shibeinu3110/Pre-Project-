package com.example.l3.service;
import com.example.l3.dto.RelationshipDto;

import java.util.List;

import static com.example.l3.consts.StoredProcedureConst.*;

public interface RelationshipService {
    RelationshipDto createRelationship(RelationshipDto relationshipDto);
    RelationshipDto getRelationShipById(Long id);
    List<RelationshipDto> getRelationshipsByEmployeeId(Long id);
    List<RelationshipDto> getAllRelationship();
    void deleteById(Long id);
    RelationshipDto updateRelationship(Long id, RelationshipDto relationshipDto);
}
