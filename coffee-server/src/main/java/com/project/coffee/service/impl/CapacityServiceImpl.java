package com.project.coffee.service.impl;

import com.project.coffee.model.Capacity;
import com.project.coffee.repository.CapacityRepository;
import com.project.coffee.service.CapacityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CapacityServiceImpl implements CapacityService {
    @Autowired
    private CapacityRepository capacityRepository;

    @Override
    public List<Capacity> findAll() {
        return capacityRepository.findAll();
    }

    @Override
    public Optional<Capacity> findById(String id) {
        return capacityRepository.findById(id);
    }


    @Override
    public void save(Capacity capacity) {
        capacityRepository.save(capacity);
    }

    @Override
    public void remove(String id) {
        capacityRepository.deleteById(id);
    }
}
