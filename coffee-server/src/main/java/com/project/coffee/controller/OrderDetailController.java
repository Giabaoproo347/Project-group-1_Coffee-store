package com.project.coffee.controller;

import com.project.coffee.model.Order;
import com.project.coffee.model.OrderDetails;
import com.project.coffee.service.OrderDetailService;
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
@RequestMapping("/api/order-detail")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("")
    public ResponseEntity<Iterable<OrderDetails>> showListOrderDetails() {
        Iterable<OrderDetails> orderDetails = orderDetailService.findAll();
        return new ResponseEntity<Iterable<OrderDetails>>(orderDetails, HttpStatus.OK);
    }

    @PostMapping("")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity addNewOrderDetail(@Valid @RequestBody OrderDetails orderDetails) {
        try {
            orderDetailService.save(orderDetails);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetails> getOrderDetailById(@PathVariable String id) {
        Optional<OrderDetails> orderDetails = orderDetailService.findById(id);
        if (orderDetails.isPresent()) {
            System.out.println("find Order");
            return new ResponseEntity<OrderDetails>(orderDetails.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<OrderDetails> updateOrderDetail(@PathVariable String id, @RequestBody OrderDetails orderDetails) {
        Optional<OrderDetails> currentOrderDetail = orderDetailService.findById(id);
        if (currentOrderDetail.isPresent()) {
            currentOrderDetail.get().setOrderDetailId(id);
            currentOrderDetail.get().setSalePrice(orderDetails.getSalePrice());
            currentOrderDetail.get().setQuantity(orderDetails.getQuantity());
            currentOrderDetail.get().setTotalPay(orderDetails.getTotalPay());
            currentOrderDetail.get().setOrder(orderDetails.getOrder());
            currentOrderDetail.get().setProductDetails(orderDetails.getProductDetails());

            orderDetailService.save(currentOrderDetail.get());
            return new ResponseEntity<OrderDetails>(currentOrderDetail.get(), HttpStatus.OK);
        }
        return new ResponseEntity<OrderDetails>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<OrderDetails> deleteOrderDetail(@PathVariable String id) {
        Optional<OrderDetails> orderDetails = orderDetailService.findById(id);
        if (orderDetails.isPresent()) {
            orderDetailService.remove(id);
            return new ResponseEntity<OrderDetails>(HttpStatus.OK);
        }
        return new ResponseEntity<OrderDetails>(HttpStatus.NOT_FOUND);
    }




}