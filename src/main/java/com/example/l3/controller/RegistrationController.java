package com.example.l3.controller;

import com.example.l3.commons.OctResponse;
import com.example.l3.dto.RegistrationDto;
import com.example.l3.service.RegistrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/registration")
public class RegistrationController {
    private final RegistrationService registrationService;

    @PostMapping()
    public OctResponse<RegistrationDto> createRegistration(@Valid @RequestBody RegistrationDto registrationDto) {
        return OctResponse.build(registrationService.createRegistration(registrationDto), "create registration successfully");
    }

    @GetMapping("/{id}")
    public OctResponse<RegistrationDto> getRegistrationById(@PathVariable("id") Long id) {
        return OctResponse.build(registrationService.getRegistrationById(id), "get registration with id: " + id + " successfully");
    }

    @GetMapping("/getAll")
    public OctResponse<List<RegistrationDto>> getAllRegistration() {
        return OctResponse.build(registrationService.getAllRegistration(), "get all registration successfully");
    }

    @DeleteMapping("/{id}")
    public OctResponse<String> deleteRegistrationById(@PathVariable("id") Long id) {
        registrationService.deleteRegistrationById(id);
        return OctResponse.build("delete registration with id: " + id + " successfully");
    }

    @PutMapping("/{id}")
    public OctResponse<RegistrationDto> updateRegistration(@PathVariable("id") Long id, @RequestBody RegistrationDto registrationDto) {
        return OctResponse.build(registrationService.updateRegistration(id, registrationDto), "update registration with id: " + id + " successfully");
    }

    @PutMapping("/submit/{id}")
    public OctResponse<RegistrationDto> submitRegistration(@PathVariable("id") Long id, @RequestBody RegistrationDto registrationDto) {
        return OctResponse.build(registrationService.submitRegistration(id, registrationDto), "submit registration with id: " + id + " successfully");
    }
}
