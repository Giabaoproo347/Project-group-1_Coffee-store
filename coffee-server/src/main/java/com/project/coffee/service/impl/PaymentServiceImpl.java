package com.project.coffee.service.impl;

import com.project.coffee.model.Payments;
import com.project.coffee.repository.PaymentRepository;
import com.project.coffee.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Iterable<Payments> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Optional<Payments> findById(String id) {
        return paymentRepository.findById(id);
    }

    @Override
    public void save(Payments payments) {
        paymentRepository.save(payments);
    }

    @Override
    public void remove(String id) {
        paymentRepository.deleteById(id);
    }
}
