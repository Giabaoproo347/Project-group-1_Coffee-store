package com.project.coffee.controller;

import com.project.coffee.model.Members;
import com.project.coffee.model.Order;
import com.project.coffee.service.OrderService;
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
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("")
    public ResponseEntity<Iterable<Order>> showListOrders() {
        Iterable<Order> orders = orderService.findAll();
        return new ResponseEntity<Iterable<Order>>(orders, HttpStatus.OK);
    }

    @PostMapping("")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity addNewOrder(@Valid @RequestBody Order order) {
        try {
            orderService.save(order);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable String id) {
        Optional<Order> order = orderService.findById(id);
        if (order.isPresent()) {
            System.out.println("find Order");
            return new ResponseEntity<Order>(order.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Order> updateOrder(@PathVariable String id, @RequestBody Order order) {
        Optional<Order> currentOrder = orderService.findById(id);
        if (currentOrder.isPresent()) {
            currentOrder.get().setOrderId(id);
            currentOrder.get().setPurchaseDate(order.getPurchaseDate());
            currentOrder.get().setDeliveryDate(order.getDeliveryDate());
            currentOrder.get().setOrderDescription(order.getOrderDescription());
            currentOrder.get().setMembers(order.getMembers());
            currentOrder.get().setPayments(order.getPayments());
            currentOrder.get().setOrderDetails(order.getOrderDetails());

            orderService.save(currentOrder.get());
            return new ResponseEntity<Order>(currentOrder.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Order> deleteOrder(@PathVariable String id) {
        Optional<Order> order = orderService.findById(id);
        if (order.isPresent()) {
            orderService.remove(id);
            return new ResponseEntity<Order>(HttpStatus.OK);
        }
        return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
    }
}
