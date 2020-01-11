package com.project.coffee.controller;

import com.project.coffee.model.OrderDetails;
import com.project.coffee.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("/orderDetails")
    public ResponseEntity<List<OrderDetails>> listAllOrderDetails() {
        List<OrderDetails> orderDetails =(List<OrderDetails>) orderDetailService.findAll();
        if (orderDetails.isEmpty()) {
            return new ResponseEntity<List<OrderDetails>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<OrderDetails>>(orderDetails, HttpStatus.OK);
    }


    @GetMapping("/orderDetails/{id}")
    public ResponseEntity<OrderDetails> getOrderDetails(@PathVariable String id) {
        OrderDetails orderDetails = orderDetailService.findById(id);
        if (orderDetails == null) {
            return new ResponseEntity<OrderDetails>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<OrderDetails>(orderDetails, HttpStatus.OK);
    }

    @PostMapping("/orderDetails")
    public ResponseEntity<Void> createOrderDetails(@RequestBody OrderDetails orderDetails, UriComponentsBuilder ucBuider) {
        orderDetailService.save(orderDetails);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuider.path("/orderDetails{id}").buildAndExpand(orderDetails.getOrderDetailId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/orderDetails/{id}")
    public ResponseEntity<OrderDetails> updateOrderDetails(@PathVariable String id, @RequestBody OrderDetails orderDetails) {
        OrderDetails currentOrderDetails = orderDetailService.findById(id);

        if (currentOrderDetails == null) {
            return new ResponseEntity<OrderDetails>(HttpStatus.NOT_FOUND);
        }

        currentOrderDetails.setSalePrice(orderDetails.getSalePrice());
        currentOrderDetails.setQuantity(orderDetails.getQuantity());
        currentOrderDetails.setTotalPay(orderDetails.getTotalPay());

        orderDetailService.save(currentOrderDetails);
        return new ResponseEntity<OrderDetails>(currentOrderDetails, HttpStatus.OK);
    }
}