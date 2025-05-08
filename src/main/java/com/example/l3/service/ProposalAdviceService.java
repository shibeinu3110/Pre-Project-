package com.example.l3.service;

import com.example.l3.dto.ProposalAdviceDto;

import java.util.List;

public interface ProposalAdviceService {
    ProposalAdviceDto createProposal(ProposalAdviceDto proposalAdviceDto);

    ProposalAdviceDto getProposal(Long id);

    List<ProposalAdviceDto> getAllProposal();

    void deleteProposal(Long id);

    ProposalAdviceDto updateProposal(Long id, ProposalAdviceDto proposalAdviceDto);

    ProposalAdviceDto submitProposal(Long id, ProposalAdviceDto proposalAdviceDto);

    ProposalAdviceDto updateProposalByLeader(Long id, ProposalAdviceDto proposalAdviceDto);


}
