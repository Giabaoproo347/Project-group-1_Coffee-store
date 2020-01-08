package com.project.coffee.service;
import com.project.coffee.model.Promotion;

public interface PromotionService {
    Iterable<Promotion> findAll();
    Promotion findById(Long id);
    void save (Promotion product);
    void remove (Long id);
}
