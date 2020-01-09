package com.project.coffee.service;

import com.project.coffee.model.Categories;

public interface CategoriesService {
    Iterable<Categories> findAll();
    Categories findById(Long id);
    void save ( Categories categories);
    void  remove (Long id);
}
