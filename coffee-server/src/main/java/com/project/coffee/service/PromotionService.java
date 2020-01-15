package com.project.coffee.service;
import com.project.coffee.model.Promotion;

import java.util.Optional;

public interface PromotionService {
    Iterable<Promotion> findAll();
    Optional<Promotion> findById(String id);
    void save (Promotion product);
    void remove (String id);
}
