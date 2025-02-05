package com.example.l3.service;

import com.example.l3.dto.SalaryIncrementDto;

import java.util.List;

public interface SalaryIncrementService {
    SalaryIncrementDto createSalaryIncrement(SalaryIncrementDto salaryIncrementDto);

    SalaryIncrementDto getSalaryIncrementById(Long id);

    List<SalaryIncrementDto> getAllSalaryIncrement();

    void deleteSalaryIncrementById(Long id);

    SalaryIncrementDto updateSalaryIncrement(Long id, SalaryIncrementDto salaryIncrementDto);

    SalaryIncrementDto submitSalaryIncrement(Long id, SalaryIncrementDto salaryIncrementDto);

    SalaryIncrementDto updateSalaryIncrementByLeader(Long id, SalaryIncrementDto salaryIncrementDto);
}
