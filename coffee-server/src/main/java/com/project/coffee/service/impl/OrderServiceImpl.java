package com.project.coffee.service.impl;

import com.project.coffee.model.Order;
import com.project.coffee.repository.OrderRepository;
import com.project.coffee.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(String id) {
        return orderRepository.findById(id);
    }


    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void remove(String id) {
        orderRepository.deleteById(id);
    }
}
