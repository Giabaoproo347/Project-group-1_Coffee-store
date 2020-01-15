package com.project.coffee.service.impl;

import com.project.coffee.model.ProductDetails;

import com.project.coffee.repository.ProductDetailsRepository;
import com.project.coffee.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ProductDetailsServiceImpl implements ProductDetailsService {
    @Autowired
    private ProductDetailsRepository productDetailsRepository;

    @Override
    public Iterable<ProductDetails> findAll() {
        return productDetailsRepository.findAll();
    }

    @Override
    public Optional<ProductDetails> findById(String id) {
        return productDetailsRepository.findById(id);
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
