package com.example.l3.controller;

import com.example.l3.commons.OctResponse;
import com.example.l3.dto.EmployeeDto;
import com.example.l3.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping()
    public OctResponse<EmployeeDto> createEmployee(@RequestPart("employee") EmployeeDto employeeDto, @RequestPart("file") MultipartFile multipartFile) throws Exception {
        EmployeeDto employeeDto1 = employeeService.createEmployee(employeeDto, multipartFile);
        return OctResponse.build(employeeDto1, "create employee successfully");
    }

    @GetMapping("/{id}")
    public OctResponse<EmployeeDto> getEmployee(@PathVariable("id") Long id) {
        return OctResponse.build(employeeService.getEmployeeById(id), "get employee by id: " + id + " successfully");
    }

    @DeleteMapping("/{id}")
    public OctResponse<String> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return OctResponse.build("delete employee by id: " + id + " successfully");
    }

    @PutMapping("/{id}")
    public OctResponse<EmployeeDto> updateEmployee(@PathVariable("id") Long id,
                                                   @RequestPart("employee") EmployeeDto employeeDto,
                                                   @RequestPart("file") MultipartFile file) {
        return OctResponse.build(employeeService.updateEmployee(id, employeeDto, file), "update employee with id: " + id + " successfully");
    }

    @GetMapping("/getAll")
    public OctResponse<List<EmployeeDto>> getAllEmployee() {
        return OctResponse.build(employeeService.getAllEmployee(), "get all employee successfully");
    }
}

