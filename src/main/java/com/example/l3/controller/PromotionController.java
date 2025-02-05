package com.example.l3.controller;

import com.example.l3.commons.OctResponse;
import com.example.l3.dto.PromotionDto;
import com.example.l3.service.PromotionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/promotion")
public class PromotionController {
    private final PromotionService promotionService;
    @PostMapping()
    public OctResponse<PromotionDto> createPromotion( @RequestBody PromotionDto promotionDto) {
        return OctResponse.build(promotionService.createPromotion(promotionDto), "create promotion successfully");
    }
    @GetMapping("/{id}")
    public OctResponse<PromotionDto> getPromotionById(@PathVariable("id") Long id) {
        return OctResponse.build(promotionService.getPromotionById(id), "get promotion by id:" +id + " successfully");
    }
    @GetMapping("/getAll")
    public OctResponse<List<PromotionDto>> getAllPromotion() {
        return OctResponse.build(promotionService.getAllPromotion(), "get all promotion successfully");
    }
    @DeleteMapping("/{id}")
    public OctResponse<String> deletePromotion(@PathVariable("id") Long id) {
        promotionService.deletePromotion(id);
        return OctResponse.build("delete promotion with id: " + id + " successfully");
    }
    @PutMapping("/{id}")
    public OctResponse<PromotionDto> updatePromotion(@PathVariable("id") Long id,
                                                     @Valid @RequestBody PromotionDto promotionDto) {
        return OctResponse.build(promotionService.updatePromotion(id, promotionDto), "update promotion with id: " + id + "successfully");
    }
    @PutMapping("/submit/{id}")
    public OctResponse<PromotionDto> submitPromotion(@PathVariable("id") Long id,
                                                     @RequestBody PromotionDto promotionDto) {
        return OctResponse.build(promotionService.submitPromotion(id, promotionDto), "update promotion with id: " + id + " successfully");
    }
}
