package com.example.l3.service;

import com.example.l3.dto.PromotionDto;

import java.util.List;

public interface PromotionService {
    PromotionDto createPromotion(PromotionDto promotionDto);

    PromotionDto getPromotionById(Long id);

    List<PromotionDto> getAllPromotion();

    void deletePromotion(Long id);

    PromotionDto updatePromotion(Long id, PromotionDto promotionDto);

    PromotionDto submitPromotion(Long id, PromotionDto promotionDto);

    PromotionDto updatePromotionByLeader(Long id, PromotionDto promotionDto);
}
