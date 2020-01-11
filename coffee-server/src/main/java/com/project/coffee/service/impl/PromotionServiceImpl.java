package com.project.coffee.service.impl;

import com.project.coffee.model.Promotion;
import com.project.coffee.repository.PromotionRepository;
import com.project.coffee.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;

public class PromotionServiceImpl implements PromotionService {
    @Autowired
    private PromotionRepository promotionRepository;
    @Override
    public Iterable<Promotion> findAll() {
        return promotionRepository.findAll();
    }

    @Override
    public Promotion findById(String id) {
        return promotionRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Promotion promotion) {
promotionRepository.save(promotion);
    }

    @Override
    public void remove(String id) {
promotionRepository.deleteById(id);
    }
}
