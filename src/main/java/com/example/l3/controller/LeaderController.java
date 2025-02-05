package com.example.l3.controller;

import com.example.l3.commons.OctResponse;
import com.example.l3.dto.*;
import com.example.l3.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/leader")
@RequiredArgsConstructor
public class LeaderController {
    private final SalaryIncrementService salaryIncrementService;
    private final PromotionService promotionService;
    private final ProposalAdviceService proposalAdviceService;
    private final RegistrationService registrationService;
    private final ProfileEndService profileEndService;

    @PutMapping("/salary-increment/{id}")
    public OctResponse<SalaryIncrementDto> updateSalaryIncrementByLeader(@PathVariable("id") Long id,
                                                                         @RequestBody SalaryIncrementDto salaryIncrementDto) {
        return OctResponse.build(salaryIncrementService.updateSalaryIncrementByLeader(id, salaryIncrementDto), "update salary increment by leader successfully");
    }

    @PutMapping("/promotion/{id}")
    public OctResponse<PromotionDto> updatePromotionByLeader(@PathVariable("id") Long id,
                                                             @RequestBody PromotionDto promotionDto) {
        return OctResponse.build(promotionService.updatePromotionByLeader(id, promotionDto), "update promotion by leader successfully");
    }

    @PutMapping("/proposal-advice/{id}")
    public OctResponse<ProposalAdviceDto> updateProposalAdviceByLeader(@PathVariable("id") Long id,
                                                                       @RequestBody ProposalAdviceDto proposalAdviceDto) {
        return OctResponse.build(proposalAdviceService.updateProposalByLeader(id, proposalAdviceDto), "update proposal with id: " + id + " successfully");
    }

    @PutMapping("/registration/{id}")
    public OctResponse<RegistrationDto> updateRegistrationByLeader(@PathVariable("id") Long id,
                                                                   @RequestBody RegistrationDto registrationDto) {
        return OctResponse.build(registrationService.updateRegistrationByLeader(id, registrationDto), "update registration with id: " + id + " successfully");
    }

    @PutMapping("/profile-end/{id}")
    public OctResponse<ProfileEndDto> updateProfileEndByLeader(@PathVariable("id") Long id,
                                                               @RequestBody ProfileEndDto profileEndDto) {
        return OctResponse.build(profileEndService.updateProfileEndByLeader(id, profileEndDto), "update registration with id: " + id + " successfully");
    }
}
