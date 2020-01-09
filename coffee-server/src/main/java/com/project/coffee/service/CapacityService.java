package com.project.coffee.service;

import com.project.coffee.model.Capacity;

public interface CapacityService {
    Iterable<Capacity> findAll();

    Capacity findById(Long id);

    void save(Capacity capacity);

    void remove(Long id);
}
