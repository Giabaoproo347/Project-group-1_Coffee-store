package com.project.coffee.service;

import com.project.coffee.model.Payments;

import java.util.Optional;

public interface PaymentService {
    Iterable<Payments> findAll();
    Optional<Payments> findById (String id);
    void save (Payments payments);
    void remove (String id);
}
