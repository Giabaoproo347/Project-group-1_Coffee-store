package com.project.coffee.service;

import com.project.coffee.model.Product;

public interface ProductService {
    Iterable<Product> findAll();
    Product findById(Long id);
    void save (Product product);
    void remove (Long id);
}
