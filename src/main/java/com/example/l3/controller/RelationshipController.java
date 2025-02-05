package com.example.l3.controller;

import com.example.l3.commons.OctResponse;
import com.example.l3.dto.RelationshipDto;
import com.example.l3.service.RelationshipService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/relationship")
public class RelationshipController {
    private final RelationshipService relationshipService;
    @PostMapping()
    public OctResponse<RelationshipDto> createRelationship(@RequestBody RelationshipDto relationshipDto) {
        return OctResponse.build(relationshipService.createRelationship(relationshipDto), "create new relationship successfully");
    }

    @GetMapping("/{id}")
    public OctResponse<RelationshipDto> getRelationshipById(@PathVariable("id") Long id) {
        return OctResponse.build(relationshipService.getRelationShipById(id), "get relationship by id:" + id + " successfully");
    }

    @GetMapping("/employee/{id}")
    public OctResponse<List<RelationshipDto>> getRelationshipByEmployeeId(@PathVariable("id") Long id) {
        return OctResponse.build(relationshipService.getRelationshipsByEmployeeId(id), "get all relationship by employee id:" + id + " successfully");
    }
    @GetMapping("/getAll")
    public OctResponse<List<RelationshipDto>> getAllRelationship() {
        return OctResponse.build(relationshipService.getAllRelationship(), "get all relationship successfully");
    }

    @DeleteMapping("/{id}")
    public OctResponse<String> deleteRelationship(@PathVariable("id") Long id) {
        relationshipService.deleteById(id);
        return OctResponse.build("delete relationship by id:" + id + " successfully");
    }
    @PutMapping("/{id}")
    public OctResponse<RelationshipDto> updateRelationship(@PathVariable("id") Long id,
                                                           @RequestBody RelationshipDto relationshipDto) {
        return OctResponse.build(relationshipService.updateRelationship(id, relationshipDto), "update relationship with id:" + id + " successfully");
    }
}
