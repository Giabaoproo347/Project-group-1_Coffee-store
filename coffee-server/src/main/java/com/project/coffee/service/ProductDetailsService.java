package com.project.coffee.service;

import com.project.coffee.model.ProductDetails;

import java.util.Optional;

public interface ProductDetailsService {
    Iterable<ProductDetails> findAll();

    Optional<ProductDetails> findById(String id);

    void save(ProductDetails productDetails);

    void remove(String id);
}
