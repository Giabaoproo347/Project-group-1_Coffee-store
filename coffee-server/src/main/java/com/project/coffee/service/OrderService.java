package com.project.coffee.service;

import com.project.coffee.model.Order;

import java.util.Optional;

public interface OrderService {
    Iterable<Order> findAll();
    Optional<Order> findById(String id);
    void save (Order order);
    void remove (String id);
}
