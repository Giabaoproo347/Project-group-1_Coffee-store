package com.project.coffee.service;

import com.project.coffee.model.ProductDetails;

public interface ProductDetailsService {
    Iterable<ProductDetails> findAll();

    ProductDetails findById(Long id);

    void save(ProductDetails productDetails);

    void remove(Long id);
}
