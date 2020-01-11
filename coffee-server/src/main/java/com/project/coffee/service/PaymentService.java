package com.project.coffee.service;

import com.project.coffee.model.Payments;

public interface PaymentService {
    Iterable<Payments> findAll();
    Payments findById (String id);
    void save (Payments payments);
    void remove (String id);
}
