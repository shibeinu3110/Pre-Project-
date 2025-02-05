package com.example.l3.service.impl;

import com.example.l3.consts.Status;
import com.example.l3.dto.ProposalAdviceDto;
import com.example.l3.helper.JsonHelper;
import com.example.l3.service.ProposalAdviceService;
import com.example.l3.validator.AuthenticationValidator;
import com.example.l3.validator.EmployeeValidator;
import com.example.l3.validator.ProposalAdviceValidator;
import com.example.l3.validator.StatusValidator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.example.l3.consts.StoredProcedureConst.*;

@Service
@RequiredArgsConstructor
public class ProposalAdviceServiceImpl implements ProposalAdviceService {
    private final EntityManager entityManager;
    private final ProposalAdviceValidator proposalAdviceValidator;
    private final EmployeeValidator employeeValidator;
    private final AuthenticationValidator authenticationValidator;
    private final StatusValidator statusValidator;

    @Override
    public ProposalAdviceDto createProposal(ProposalAdviceDto proposalAdviceDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        employeeValidator.existById(proposalAdviceDto.getEmployeeId());

        proposalAdviceDto.setCreatedBy(authentication.getName());
        proposalAdviceDto.setCreateDate(LocalDate.now());
        proposalAdviceDto.setStatus(Status.CREATED.getValue());

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(ProposalAdvice.CREATE_PROPOSAL_ADVICE, Mapper.PROPOSAL_ADVICE_DTO_MAPPER)
                .registerStoredProcedureParameter(Parameter.PROPOSAL_ADVICE_JSON, String.class, ParameterMode.IN)
                .setParameter(Parameter.PROPOSAL_ADVICE_JSON, JsonHelper.toJson(proposalAdviceDto));

        return (ProposalAdviceDto) query.getSingleResult();
    }

    @Override
    public ProposalAdviceDto getProposal(Long id) {
        proposalAdviceValidator.checkExistProposalAdvice(id);
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(ProposalAdvice.GET_PROPOSAL_ADVICE_BY_ID, Mapper.PROPOSAL_ADVICE_DTO_MAPPER)
                .registerStoredProcedureParameter(Parameter.PROPOSAL_ADVICE_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.PROPOSAL_ADVICE_ID, id);
        return (ProposalAdviceDto) query.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ProposalAdviceDto> getAllProposal() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(ProposalAdvice.GET_ALL_PROPOSAL, Mapper.PROPOSAL_ADVICE_DTO_MAPPER);

        return mapObjectListToProposal(query.getResultList());
    }

    @Override
    public void deleteProposal(Long id) {
        ProposalAdviceDto proposalAdviceDto = getProposal(id);
        authenticationValidator.checkCreateByManager(proposalAdviceDto.getCreatedBy());

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(ProposalAdvice.DELETE_PROPOSAL_BY_ID)
                .registerStoredProcedureParameter(Parameter.PROPOSAL_ADVICE_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.PROPOSAL_ADVICE_ID, id);

        query.execute();
    }

    @Override
    public ProposalAdviceDto updateProposal(Long id, ProposalAdviceDto proposalAdviceDto) {
        ProposalAdviceDto currentProposal = getProposal(id);

        statusValidator.checkValidStatusForManagerUpdate(currentProposal.getStatus());
        authenticationValidator.checkCreateByManager(currentProposal.getCreatedBy());
        employeeValidator.existById(proposalAdviceDto.getEmployeeId());
        proposalAdviceDto.setStatus(Status.UPDATED.getValue());

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(ProposalAdvice.UPDATE_PROPOSAL_BY_MANAGER, Mapper.PROPOSAL_ADVICE_DTO_MAPPER)
                .registerStoredProcedureParameter(Parameter.PROPOSAL_ADVICE_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.PROPOSAL_ADVICE_ID, id)
                .registerStoredProcedureParameter(Parameter.PROPOSAL_ADVICE_JSON, String.class, ParameterMode.IN)
                .setParameter(Parameter.PROPOSAL_ADVICE_JSON, JsonHelper.toJson(proposalAdviceDto));
        query.execute();
        return getProposal(id);
    }

    @Override
    public ProposalAdviceDto submitProposal(Long id, ProposalAdviceDto proposalAdviceDto) {
        ProposalAdviceDto currentProposal = getProposal(id);

        authenticationValidator.checkCreateByManager(currentProposal.getCreatedBy());
        statusValidator.checkValidStatusForMangerSubmit(currentProposal.getStatus());
        authenticationValidator.checkExistLeader(proposalAdviceDto.getLeaderId());

        proposalAdviceDto.setStatus(Status.PENDING.getValue());
        proposalAdviceDto.setSubmitDate(LocalDate.now());

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(ProposalAdvice.SUBMIT_PROPOSAL, Mapper.PROPOSAL_ADVICE_DTO_MAPPER)
                .registerStoredProcedureParameter(Parameter.PROPOSAL_ADVICE_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.PROPOSAL_ADVICE_ID, id)
                .registerStoredProcedureParameter(Parameter.PROPOSAL_ADVICE_JSON, String.class, ParameterMode.IN)
                .setParameter(Parameter.PROPOSAL_ADVICE_JSON, JsonHelper.toJson(proposalAdviceDto));
        query.execute();
        return getProposal(id);
    }

    @Override
    public ProposalAdviceDto updateProposalByLeader(Long id, ProposalAdviceDto proposalAdviceDto) {
        ProposalAdviceDto currentProposal = getProposal(id);
        authenticationValidator.checkIsForLeader(currentProposal.getLeaderId());
        statusValidator.checkValidStatusForLeaderUpdate(currentProposal.getStatus());
        statusValidator.checkValidStatusForLeader(proposalAdviceDto.getStatus());

        if (proposalAdviceDto.getStatus().equalsIgnoreCase(Status.ACCEPTED.getValue())) {
            proposalAdviceDto.setStatus(Status.ACCEPTED.getValue());
            proposalAdviceDto.setAcceptDate(LocalDate.now());
        } else if (proposalAdviceDto.getStatus().equalsIgnoreCase(Status.REJECTED.getValue())) {
            proposalAdviceDto.setStatus(Status.REJECTED.getValue());
            proposalAdviceDto.setRejectDate(LocalDate.now());
        } else if (proposalAdviceDto.getStatus().equalsIgnoreCase(Status.ADDITIONAL.getValue())) {
            proposalAdviceDto.setStatus(Status.ADDITIONAL.getValue());
            proposalAdviceDto.setAdditionalDate(LocalDate.now());
        }

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(ProposalAdvice.UPDATE_PROPOSAL_BY_LEADER, Mapper.PROPOSAL_ADVICE_DTO_MAPPER)
                .registerStoredProcedureParameter(Parameter.PROPOSAL_ADVICE_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.PROPOSAL_ADVICE_ID, id)
                .registerStoredProcedureParameter(Parameter.PROPOSAL_ADVICE_JSON, String.class, ParameterMode.IN)
                .setParameter(Parameter.PROPOSAL_ADVICE_JSON, JsonHelper.toJson(proposalAdviceDto));
        query.execute();

        return getProposal(id);
    }



    private List<ProposalAdviceDto> mapObjectListToProposal(List<Object> objectList) {
        List<ProposalAdviceDto> proposalAdviceDtoList = new ArrayList<>();
        for(Object object : objectList) {
            if(object instanceof ProposalAdviceDto) {
                proposalAdviceDtoList.add((ProposalAdviceDto) object);
            }
        }
        return proposalAdviceDtoList;
    }

}
