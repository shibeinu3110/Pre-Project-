package com.example.l3.service.impl;

import com.example.l3.consts.Status;
import com.example.l3.consts.StoredProcedureConst;
import com.example.l3.dto.PromotionDto;
import com.example.l3.helper.JsonHelper;
import com.example.l3.service.PromotionService;
import com.example.l3.validator.AuthenticationValidator;
import com.example.l3.validator.EmployeeValidator;
import com.example.l3.validator.PromotionValidator;
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
public class PromotionServiceImpl implements PromotionService {
    private final EntityManager entityManager;
    private final EmployeeValidator employeeValidator;
    private final PromotionValidator promotionValidator;
    private final AuthenticationValidator authenticationValidator;
    private final StatusValidator statusValidator;

    @Override
    public PromotionDto createPromotion(PromotionDto promotionDto) {
        employeeValidator.existById(promotionDto.getEmployeeId());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        promotionDto.setCreateDate(LocalDate.now());
        promotionDto.setCreatedBy(authentication.getName());
        promotionDto.setStatus(Status.CREATED.getValue());

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(Promotion.CREATE_PROMOTION, Mapper.PROMOTION_DTO_MAPPER)
                .registerStoredProcedureParameter(Parameter.PROMOTION_JSON, String.class, ParameterMode.IN)
                .setParameter(Parameter.PROMOTION_JSON, JsonHelper.toJson(promotionDto));
        return (PromotionDto) query.getSingleResult();
    }

    @Override
    public PromotionDto getPromotionById(Long id) {
        promotionValidator.checkExistPromotion(id);
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(Promotion.GET_PROMOTION_BY_ID, Mapper.PROMOTION_DTO_MAPPER)
                .registerStoredProcedureParameter(Parameter.PROMOTION_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.PROMOTION_ID, id);

        return (PromotionDto) query.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PromotionDto> getAllPromotion() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(Promotion.GET_ALL_PROMOTION, Mapper.PROMOTION_DTO_MAPPER);
        return mapObjectListToPromotionList(query.getResultList());
    }

    @Override
    public void deletePromotion(Long id) {
        promotionValidator.checkExistPromotion(id);
        authenticationValidator.checkCreateByManager(getPromotionById(id).getCreatedBy());
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(Promotion.DELETE_PROMOTION_BY_ID)
                .registerStoredProcedureParameter(Parameter.PROMOTION_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.PROMOTION_ID, id);

        query.execute();
    }

    @Override
    public PromotionDto updatePromotion(Long id, PromotionDto promotionDto) {
        PromotionDto currentPromotion = getPromotionById(id);

        employeeValidator.existById(promotionDto.getEmployeeId());
        authenticationValidator.checkCreateByManager(currentPromotion.getCreatedBy());
        statusValidator.checkValidStatusForManagerUpdate(currentPromotion.getStatus());
        promotionDto.setStatus(Status.UPDATED.getValue());

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(Promotion.UPDATE_PROMOTION_BY_MANAGER, Mapper.PROMOTION_DTO_MAPPER)
                .registerStoredProcedureParameter(Parameter.PROMOTION_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.PROMOTION_ID, id)
                .registerStoredProcedureParameter(Parameter.PROMOTION_JSON, String.class, ParameterMode.IN)
                .setParameter(Parameter.PROMOTION_JSON, JsonHelper.toJson(promotionDto));

        query.execute();
        return getPromotionById(id);
    }

    @Override
    public PromotionDto submitPromotion(Long id, PromotionDto promotionDto) {
        PromotionDto currentPromotion = getPromotionById(id);
        authenticationValidator.checkCreateByManager(currentPromotion.getCreatedBy());
        statusValidator.checkValidStatusForMangerSubmit(currentPromotion.getStatus());
        authenticationValidator.checkExistLeader(promotionDto.getLeaderId());
        promotionDto.setStatus(Status.PENDING.getValue());
        promotionDto.setSubmitDate(LocalDate.now());

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(Promotion.SUBMIT_PROMOTION, Mapper.PROMOTION_DTO_MAPPER)
                .registerStoredProcedureParameter(Parameter.PROMOTION_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.PROMOTION_ID, id)
                .registerStoredProcedureParameter(Parameter.PROMOTION_JSON, String.class, ParameterMode.IN)
                .setParameter(Parameter.PROMOTION_JSON, JsonHelper.toJson(promotionDto));

        query.execute();

        return getPromotionById(id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public PromotionDto updatePromotionByLeader(Long id, PromotionDto promotionDto) {
        PromotionDto currentPromotion = getPromotionById(id);
        authenticationValidator.checkIsForLeader(promotionDto.getLeaderId());
        statusValidator.checkValidStatusForLeaderUpdate(currentPromotion.getStatus());
        statusValidator.checkValidStatusForLeader(promotionDto.getStatus());

        if (promotionDto.getStatus().equalsIgnoreCase(Status.ACCEPTED.getValue())) {
            promotionDto.setStatus(Status.ACCEPTED.getValue());
            promotionDto.setAcceptDate(LocalDate.now());
        } else if (promotionDto.getStatus().equalsIgnoreCase(Status.REJECTED.getValue())) {
            promotionDto.setStatus(Status.REJECTED.getValue());
            promotionDto.setRejectDate(LocalDate.now());
        } else if (promotionDto.getStatus().equalsIgnoreCase(Status.ADDITIONAL.getValue())) {
            promotionDto.setStatus(Status.ADDITIONAL.getValue());
            promotionDto.setAdditionalDate(LocalDate.now());
        }
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(Promotion.UPDATE_PROMOTION_BY_LEADER, Mapper.PROMOTION_DTO_MAPPER)
                .registerStoredProcedureParameter(Parameter.PROMOTION_ID, Long.class, ParameterMode.IN)
                .setParameter(Parameter.PROMOTION_ID, id)
                .registerStoredProcedureParameter(Parameter.PROMOTION_JSON, String.class, ParameterMode.IN)
                .setParameter(Parameter.PROMOTION_JSON, JsonHelper.toJson(promotionDto));
        query.execute();
        return getPromotionById(id);
    }

    private List<PromotionDto> mapObjectListToPromotionList(List<Object> objectList) {
        List<PromotionDto> promotionDtoList = new ArrayList<>();
        for(Object object : objectList) {
            if(object instanceof  PromotionDto) {
                promotionDtoList.add((PromotionDto) object);
            }
        }
        return promotionDtoList;
    }
}
