package com.example.l3.controller;

import com.example.l3.commons.OctResponse;
import com.example.l3.dto.ProposalAdviceDto;
import com.example.l3.service.ProposalAdviceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/proposal-advice")
public class ProposalAdviceController {
    private final ProposalAdviceService proposalAdviceService;

    @PostMapping()
    public OctResponse<ProposalAdviceDto> createProposalAdvice(@Valid @RequestBody ProposalAdviceDto proposalAdviceDto) {
        return OctResponse.build(proposalAdviceService.createProposal(proposalAdviceDto), "create proposal advice successfully");
    }

    @GetMapping("/{id}")
    public OctResponse<ProposalAdviceDto> getProposalAdvice(@PathVariable("id") Long id) {
        return OctResponse.build(proposalAdviceService.getProposal(id), "get proposal advice with id: " + id + " successfully");
    }

    @GetMapping("/getAll")
    public OctResponse<List<ProposalAdviceDto>> getAllProposalAdvice() {
        return OctResponse.build(proposalAdviceService.getAllProposal(), "get all proposal advices successfully");
    }

    @DeleteMapping("/{id}")
    public OctResponse<String> deleteProposalAdvice(@PathVariable("id") Long id) {
        proposalAdviceService.deleteProposal(id);
        return OctResponse.build("delete proposal with id: " + id + " successfully");
    }

    @PutMapping("/{id}")
    public OctResponse<ProposalAdviceDto> updateProposalAdvice(@PathVariable("id") Long id,
                                                               @RequestBody ProposalAdviceDto proposalAdviceDto) {
        return OctResponse.build(proposalAdviceService.updateProposal(id, proposalAdviceDto), "update proposal advice with id: " + id + " successfully");
    }

    @PutMapping("/submit/{id}")
    public OctResponse<ProposalAdviceDto> submitProposalAdvice(@PathVariable("id") Long id,
                                                               @RequestBody ProposalAdviceDto proposalAdviceDto) {
        return OctResponse.build(proposalAdviceService.submitProposal(id, proposalAdviceDto), "submit proposal with id: " + id + " successfully");
    }
}
