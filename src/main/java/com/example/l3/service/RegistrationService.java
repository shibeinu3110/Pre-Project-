package com.example.l3.service;

import com.example.l3.dto.ProposalAdviceDto;
import com.example.l3.dto.RegistrationDto;

import java.util.List;

public interface RegistrationService {
    RegistrationDto createRegistration(RegistrationDto registrationDto);

    RegistrationDto getRegistrationById(Long id);

    List<RegistrationDto> getAllRegistration();

    void deleteRegistrationById(Long id);

    RegistrationDto updateRegistration(Long id, RegistrationDto registrationDto);

    RegistrationDto submitRegistration(Long id, RegistrationDto registrationDto);

    RegistrationDto updateRegistrationByLeader(Long id, RegistrationDto registrationDto);
}
