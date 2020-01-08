package com.project.coffee.service.impl;

import com.project.coffee.model.OrderDetails;
import com.project.coffee.repository.OrderDetailRepository;
import com.project.coffee.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Override
    public Iterable<OrderDetails> findAll() {
        return orderDetailRepository.findAll();
    }

    @Override
    public OrderDetails findById(Long id) {
        return orderDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void save(OrderDetails orderDetails) {
        orderDetailRepository.save(orderDetails);
    }

    @Override
    public void remove(Long id) {
        orderDetailRepository.deleteById(id);
    }
}
