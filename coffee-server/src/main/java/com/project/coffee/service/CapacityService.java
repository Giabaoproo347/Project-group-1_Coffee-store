package com.project.coffee.service;

import com.project.coffee.model.Capacity;

public interface CapacityService {
    Iterable<Capacity> findAll();

    Capacity findById(String id);

    void save(Capacity capacity);

    void remove(String id);
}
