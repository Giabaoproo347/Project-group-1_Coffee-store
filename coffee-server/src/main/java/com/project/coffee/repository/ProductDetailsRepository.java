package com.project.coffee.repository;

import com.project.coffee.model.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailsRepository extends JpaRepository<ProductDetails, String> {
}
