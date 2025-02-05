package com.example.l3.controller;

import com.example.l3.commons.OctResponse;
import com.example.l3.dto.SalaryIncrementDto;
import com.example.l3.service.SalaryIncrementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/salary-increment")
public class SalaryIncrementController {
    private final SalaryIncrementService service;
    @PostMapping()
    public OctResponse<SalaryIncrementDto> creatSalaryIncrement(@Valid @RequestBody SalaryIncrementDto salaryIncrementDto) {
        return OctResponse.build(service.createSalaryIncrement(salaryIncrementDto), "create salary increment successfully");
    }
    @GetMapping("/{id}")
    public OctResponse<SalaryIncrementDto> getSalaryIncrementById(@PathVariable("id") Long id) {
        return OctResponse.build(service.getSalaryIncrementById(id), "get salary increment by id " + id + " successfully");
    }
    @GetMapping("/getAll")
    public OctResponse<List<SalaryIncrementDto>> getAllSalaryIncrement() {
        return OctResponse.build(service.getAllSalaryIncrement(), "get all salary increment successfully");
    }
    @DeleteMapping("/{id}")
    public OctResponse<String> deleteSalaryIncrementById(@PathVariable("id") Long id) {
        service.deleteSalaryIncrementById(id);
        return OctResponse.build("delete salary increment with id: " + id + " successfully" );
    }
    @PutMapping("/{id}")
    public OctResponse<SalaryIncrementDto> updateSalaryIncrement(@PathVariable("id") Long id,
                                                                 @RequestBody SalaryIncrementDto salaryIncrementDto) {
        return OctResponse.build(service.updateSalaryIncrement(id, salaryIncrementDto), "update salary increment with id: " + id +  " successfully" );
    }
    @PutMapping("/submit/{id}")
    public OctResponse<SalaryIncrementDto> submitSalaryIncrement(@PathVariable("id") Long id,
                                                                 @RequestBody SalaryIncrementDto salaryIncrementDto) {
        return OctResponse.build(service.submitSalaryIncrement(id, salaryIncrementDto), "submit salary increment successfully");
    }


}
