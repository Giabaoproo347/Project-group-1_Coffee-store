package com.project.coffee.service.impl;

import com.project.coffee.model.Payments;
import com.project.coffee.repository.PaymentRepository;
import com.project.coffee.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;

public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Iterable<Payments> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payments findById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Payments payments) {
        paymentRepository.save(payments);
    }

    @Override
    public void remove(Long id) {
        paymentRepository.deleteById(id);
    }
}
