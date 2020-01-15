package com.project.coffee.controller;

import com.project.coffee.model.Order;
import com.project.coffee.model.OrderDetails;
import com.project.coffee.model.Payments;
import com.project.coffee.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin( origins = "*", maxAge = 3600)
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("")
    public ResponseEntity<Iterable<Payments>> showListPayments() {
        Iterable<Payments> payments = paymentService.findAll();
        return new ResponseEntity<Iterable<Payments>>(payments, HttpStatus.OK);
    }

    @PostMapping("")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity addNewPayment(@Valid @RequestBody Payments payments) {
        try {
            paymentService.save(payments);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payments> getPaymentById(@PathVariable String id) {
        Optional<Payments> payments = paymentService.findById(id);
        if (payments.isPresent()) {
            System.out.println("find Payment");
            return new ResponseEntity<Payments>(payments.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Payments> updatePayment(@PathVariable String id, @RequestBody Payments payments) {
        Optional<Payments> currentPayment = paymentService.findById(id);
        if (currentPayment.isPresent()) {
            currentPayment.get().setPaymentId(id);
            currentPayment.get().setPaymentName(payments.getPaymentName());
            currentPayment.get().setPaymentDate(payments.getPaymentDate());
            currentPayment.get().setOrders(payments.getOrders());

            paymentService.save(currentPayment.get());
            return new ResponseEntity<Payments>(currentPayment.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Payments>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Payments> deletePayment(@PathVariable String id) {
        Optional<Payments> payments = paymentService.findById(id);
        if (payments.isPresent()) {
            paymentService.remove(id);
            return new ResponseEntity<Payments>(HttpStatus.OK);
        }
        return new ResponseEntity<Payments>(HttpStatus.NOT_FOUND);
    }
}