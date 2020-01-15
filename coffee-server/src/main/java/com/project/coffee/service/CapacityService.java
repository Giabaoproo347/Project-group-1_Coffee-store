package com.project.coffee.service;

import com.project.coffee.model.Capacity;

import java.util.Optional;

public interface CapacityService {
    Iterable<Capacity> findAll();

    Optional<Capacity> findById(String id);

    void save(Capacity capacity);

    void remove(String id);
}
