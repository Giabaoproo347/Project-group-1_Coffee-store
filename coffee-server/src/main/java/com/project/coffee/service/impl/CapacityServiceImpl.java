package com.project.coffee.service.impl;

import com.project.coffee.model.Capacity;
import com.project.coffee.repository.CapacityRepository;
import com.project.coffee.service.CapacityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CapacityServiceImpl implements CapacityService {
    @Autowired
    private CapacityRepository capacityRepository;

    @Override
    public List<Capacity> findAll() {
        return capacityRepository.findAll();
    }

    @Override
    public Capacity findById(Long id) {
        return capacityRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Capacity capacity) {
        capacityRepository.save(capacity);
    }

    @Override
    public void remove(Long id) {
        capacityRepository.deleteById(id);
    }
}
