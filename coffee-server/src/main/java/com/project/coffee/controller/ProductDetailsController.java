package com.project.coffee.controller;

import com.project.coffee.model.Product;
import com.project.coffee.model.ProductDetails;
import com.project.coffee.model.Promotion;
import com.project.coffee.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
public class ProductDetailsController {
    @Autowired
    ProductDetailsService productDetailsService;
    @GetMapping("/product-details")
    public ResponseEntity<List<ProductDetails>> listProductDetail() {
        List<ProductDetails> productDetails =(List<ProductDetails>) productDetailsService.findAll();
        if (productDetails.isEmpty()) {
            return new ResponseEntity<List<ProductDetails>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ProductDetails>>(productDetails, HttpStatus.OK);
    }

    @GetMapping("/product-details/{id}")
    public ResponseEntity<ProductDetails> getProductDetail(@PathVariable("id") String id) {
        ProductDetails productDetails = productDetailsService.findById(id);
        if (productDetails == null) {
            return new ResponseEntity<ProductDetails>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ProductDetails>(productDetails, HttpStatus.OK);
    }

    @PostMapping("/product-details")
    public ResponseEntity<Void> createProductDetail(@RequestBody ProductDetails productDetails, UriComponentsBuilder ucBuilder) {
        productDetailsService.save(productDetails);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/product-details/{id}").buildAndExpand(productDetails.getProductDetailId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


    @PutMapping("/product-details/{id}")
    public ResponseEntity<ProductDetails> updateProductDetail(@PathVariable("id") String id, @RequestBody ProductDetails productDetails) {

        ProductDetails currentProductDetail = productDetailsService.findById(id);

        if (currentProductDetail == null) {
            return new ResponseEntity<ProductDetails>(HttpStatus.NOT_FOUND);
        }

        currentProductDetail.setProductDetailId(productDetails.getProductDetailId());
        currentProductDetail.setPrice(productDetails.getPrice());
        currentProductDetail.setEntryPrice(productDetails.getEntryPrice());
        currentProductDetail.setQuantity(productDetails.getQuantity());

        productDetailsService.save(currentProductDetail);
        return new ResponseEntity<ProductDetails>(currentProductDetail, HttpStatus.OK);
    }

    @DeleteMapping("/product-details/{id}")
    public ResponseEntity<ProductDetails> deleteProductDetail(@PathVariable("id") String id) {

        ProductDetails productDetails = productDetailsService.findById(id);
        if (productDetails == null) {
            return new ResponseEntity<ProductDetails>(HttpStatus.NOT_FOUND);
        }

        productDetailsService.remove(id);
        return new ResponseEntity<ProductDetails>(HttpStatus.NO_CONTENT);
    }
}
