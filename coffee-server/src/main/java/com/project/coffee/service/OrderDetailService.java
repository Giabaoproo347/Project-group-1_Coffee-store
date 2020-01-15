package com.project.coffee.service;

import com.project.coffee.model.OrderDetails;

import java.util.Optional;

public interface OrderDetailService {
    Iterable<OrderDetails> findAll();
    Optional<OrderDetails> findById(String id);
    void save (OrderDetails orderDetails);
    void remove (String id);
}
