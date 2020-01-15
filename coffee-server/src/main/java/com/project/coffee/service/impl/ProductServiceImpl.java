package com.project.coffee.service.impl;

import com.project.coffee.model.Product;
import com.project.coffee.repository.ProductRepository;
import com.project.coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(String id) {
        return productRepository.findById(id);
    }


    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void remove(String id) {
        productRepository.deleteById(id);
    }
}
