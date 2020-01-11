package com.project.coffee.controller;

import com.project.coffee.model.Payments;
import com.project.coffee.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payments")
    public ResponseEntity<List<Payments>> listAllPayments() {
        List<Payments> payments = (List<Payments>) paymentService.findAll();
        if (payments.isEmpty()) {
            return new ResponseEntity<List<Payments>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Payments>>(HttpStatus.OK);
    }

    @GetMapping("/payments/{id}")
    public ResponseEntity<Payments> getPayment(@PathVariable String id) {
        Payments payments = paymentService.findById(id);
        if (payments == null) {
            return new ResponseEntity<Payments>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Payments>(payments, HttpStatus.OK);
    }

    @PostMapping("/payments")
    public ResponseEntity<Void> createPayment(@RequestBody Payments payments, UriComponentsBuilder ucBuider) {
        paymentService.save(payments);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuider.path("/payments{id}").buildAndExpand(payments.getPaymentId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/payments/{id}")
    public ResponseEntity<Payments> updatePayment(@PathVariable String id, @RequestBody Payments payments) {
        Payments currentPayment = paymentService.findById(id);

        if (currentPayment == null) {
            return new ResponseEntity<Payments>(HttpStatus.NOT_FOUND);
        }

        currentPayment.setPaymentId(payments.getPaymentId());
        currentPayment.setPaymentDate(payments.getPaymentDate());
        currentPayment.setPaymentName(payments.getPaymentName());

        paymentService.save(currentPayment);
        return new ResponseEntity<Payments>(currentPayment, HttpStatus.OK);
    }
}