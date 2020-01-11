package com.project.coffee.service.impl;

import com.project.coffee.model.ProductDetails;

import com.project.coffee.repository.ProductDetailsRepository;
import com.project.coffee.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductDetailsServiceImpl implements ProductDetailsService {
    @Autowired
    private ProductDetailsRepository productDetailsRepository;

    @Override
    public Iterable<ProductDetails> findAll() {
        return productDetailsRepository.findAll();
    }

    @Override
    public ProductDetails findById(String id) {
        return productDetailsRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ProductDetails productDetails) {
        productDetailsRepository.save(productDetails);
    }

    @Override
    public void remove(String id) {
        productDetailsRepository.deleteById(id);
    }
}
