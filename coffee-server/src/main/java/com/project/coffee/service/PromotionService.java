package com.project.coffee.service;
import com.project.coffee.model.Promotion;

public interface PromotionService {
    Iterable<Promotion> findAll();
    Promotion findById(String id);
    void save (Promotion product);
    void remove (String id);
}
