package com.project.coffee.service;

import com.project.coffee.model.Order;

public interface OrderService {
    Iterable<Order> findAll();
    Order findById(Long id);
    void save (Order order);
    void remove (Long id);
}
