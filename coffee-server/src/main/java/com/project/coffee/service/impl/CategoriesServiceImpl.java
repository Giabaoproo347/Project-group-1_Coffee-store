package com.project.coffee.service.impl;

import com.project.coffee.model.Categories;
import com.project.coffee.repository.CategoriesRepository;
import com.project.coffee.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoriesServiceImpl implements CategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository;
    @Override
    public Iterable<Categories> findAll() {
        return categoriesRepository.findAll();
    }

    @Override
    public Categories findById(String id) {
        return categoriesRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Categories categories) {
    categoriesRepository.save(categories);
    }

    @Override
    public void remove(String id) {
    categoriesRepository.deleteById(id);
    }
}
