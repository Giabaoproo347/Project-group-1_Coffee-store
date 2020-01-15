package com.project.coffee.service;

import com.project.coffee.model.Product;

import java.util.Optional;

public interface ProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(String id);
    void save (Product product);
    void remove (String id);
}
