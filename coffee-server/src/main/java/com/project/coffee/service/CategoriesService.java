package com.project.coffee.service;

import com.project.coffee.model.Categories;

import java.util.Optional;

public interface CategoriesService {
    Iterable<Categories> findAll();
    Optional<Categories> findById(String id);
    void save ( Categories categories);
    void  remove (String id);
}
