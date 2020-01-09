package com.project.coffee.service;

import com.project.coffee.model.Payments;

public interface PaymentService {
    Iterable<Payments> findAll();
    Payments findById (Long id);
    void save (Payments payments);
    void remove (Long id);
}
