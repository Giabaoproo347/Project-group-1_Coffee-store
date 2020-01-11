package com.project.coffee.service;

import com.project.coffee.model.ProductDetails;

public interface ProductDetailsService {
    Iterable<ProductDetails> findAll();

    ProductDetails findById(String id);

    void save(ProductDetails productDetails);

    void remove(String id);
}
