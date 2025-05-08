package com.example.l3.service;

import com.example.l3.dto.EmployeeDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto, MultipartFile multipartFile);

    EmployeeDto getEmployeeById(Long employeeId);

    void deleteEmployee(Long employeeId);

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto, MultipartFile file);

    List<EmployeeDto> getAllEmployee();
}
