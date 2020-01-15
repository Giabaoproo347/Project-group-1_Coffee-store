package com.project.coffee.controller;

import com.project.coffee.model.ProductDetails;
import com.project.coffee.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/product-detail")
public class ProductDetailsController {
    @Autowired
    ProductDetailsService productDetailsService;
    @GetMapping("")
    public ResponseEntity<Iterable<ProductDetails>> showListProductDetail() {
        Iterable<ProductDetails> productDetails = productDetailsService.findAll();
        return new ResponseEntity<Iterable<ProductDetails>>(productDetails, HttpStatus.OK);
    }

    @PostMapping("")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity addNewProductDetail(@Valid @RequestBody ProductDetails productDetails) {
        try {
            productDetailsService.save(productDetails);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDetails> getProductDetailById(@PathVariable String id) {
        Optional<ProductDetails> productDetails = productDetailsService.findById(id);
        if (productDetails.isPresent()) {
            System.out.println("find product detail");
            return new ResponseEntity<ProductDetails>(productDetails.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProductDetails> updateProductDetail(@PathVariable String id, @RequestBody ProductDetails productDetails) {
        Optional<ProductDetails> currentProductDetail = productDetailsService.findById(id);
        if (currentProductDetail.isPresent()) {
            currentProductDetail.get().setProductDetailId(id);
            currentProductDetail.get().setPrice(productDetails.getPrice());
            currentProductDetail.get().setEntryPrice(productDetails.getEntryPrice());
            currentProductDetail.get().setQuantity(productDetails.getQuantity());
            currentProductDetail.get().setCapacity(productDetails.getCapacity());
            currentProductDetail.get().setProduct(productDetails.getProduct());
            currentProductDetail.get().setOrderDetails(productDetails.getOrderDetails());

            productDetailsService.save(currentProductDetail.get());
            return new ResponseEntity<ProductDetails>(currentProductDetail.get(), HttpStatus.OK);
        }
        return new ResponseEntity<ProductDetails>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProductDetails> deleteProdcutDetail(@PathVariable String id) {
        Optional<ProductDetails> productDetails = productDetailsService.findById(id);
        if (productDetails.isPresent()) {
            productDetailsService.remove(id);
            return new ResponseEntity<ProductDetails>(HttpStatus.OK);
        }
        return new ResponseEntity<ProductDetails>(HttpStatus.NOT_FOUND);
    }
}
