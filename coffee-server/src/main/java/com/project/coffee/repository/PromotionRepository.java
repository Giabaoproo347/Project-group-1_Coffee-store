package com.project.coffee.repository;

import com.project.coffee.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<Promotion,String> {
}
