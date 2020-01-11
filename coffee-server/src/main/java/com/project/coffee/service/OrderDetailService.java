package com.project.coffee.service;

import com.project.coffee.model.OrderDetails;

public interface OrderDetailService {
    Iterable<OrderDetails> findAll();
    OrderDetails findById(String id);
    void save (OrderDetails orderDetails);
    void remove (String id);
}
