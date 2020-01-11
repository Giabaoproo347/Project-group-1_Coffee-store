package com.project.coffee.controller;

import com.project.coffee.model.Order;
import com.project.coffee.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/orders")
    public ResponseEntity<List<Order>> listAllOrders(){
        List<Order> orders = (List<Order>) orderService.findAll();
        if(orders.isEmpty()){
            return new ResponseEntity<List<Order>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getCategories(@PathVariable("id") String id) {
        System.out.println("Fetching Order with id " + id);
        Order order = orderService.findById(id);
        if (order == null) {
            System.out.println("Order with id " + id + " not found");
            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

    @PostMapping("/orders")
    public ResponseEntity<Void> createOrder(@RequestBody Order orders, UriComponentsBuilder ucBuilder) {
        orderService.save(orders);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/orders/{id}").buildAndExpand(orders.getOrderId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<Order> updateCustomer(@PathVariable("id") String id, @RequestBody Order order) {
        System.out.println("Updating order " + id);

        Order currentOrder = orderService.findById(id);

        if (currentOrder == null) {
            System.out.println("Order with id " + id + " not found");
            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        }

        currentOrder.setPurchaseDate(order.getPurchaseDate());
        currentOrder.setDeliveryDate(order.getDeliveryDate());
        currentOrder.setOrderDescription(order.getOrderDescription());

        orderService.save(currentOrder);
        return new ResponseEntity<Order>(currentOrder, HttpStatus.OK);
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<Order> deleteOrders(@PathVariable("id") String id) {
        System.out.println("Fetching & Deleting Order with id " + id);

        Order order = orderService.findById(id);
        if (order == null) {
            System.out.println("Unable to delete. Order with id " + id + " not found");
            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        }

        orderService.remove(id);
        return new ResponseEntity<Order>(HttpStatus.NO_CONTENT);
    }
}
