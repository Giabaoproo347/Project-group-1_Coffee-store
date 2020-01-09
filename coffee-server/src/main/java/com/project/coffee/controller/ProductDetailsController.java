package com.project.coffee.controller;

import com.project.coffee.model.ProductDetails;
import com.project.coffee.model.Promotion;
import com.project.coffee.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.Entity;
import java.util.List;

@Entity
@CrossOrigin(maxAge = 3600)
public class ProductDetailsController {
    @Autowired
    ProductDetailsService productDetailsService;
    @RequestMapping(value = "/productdetails", method = RequestMethod.GET)
    public ResponseEntity<List<ProductDetails>> showProductdetails(){
        List<ProductDetails> productDetails = (List<ProductDetails>) productDetailsService.findAll();
        if(productDetails.isEmpty()){
            return new ResponseEntity<List<ProductDetails>>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<List<ProductDetails>>(productDetails, HttpStatus.OK);
        }
    }

    @RequestMapping(value ="/productdetails/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProductDetails> getProductdetail(@PathVariable ("id") long id){
        ProductDetails productDetails = productDetailsService.findById(id);
        if(productDetails == null){
            System.out.println(" khong cos phan tu can lay");
            return new ResponseEntity<ProductDetails>( HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<ProductDetails>(productDetails, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/productdetails", method = RequestMethod.POST)
    public ResponseEntity<Void> createPromotion(@RequestBody ProductDetails productDetails, UriComponentsBuilder ucBuilder) {
        productDetailsService.save(productDetails);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/promotion/{id}").buildAndExpand(productDetails.getProductDetailId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/productdetail/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ProductDetails> updateProductDetail(@PathVariable("id") long id, @RequestBody ProductDetails productDetails) {

        ProductDetails _productDetails = productDetailsService.findById(id);

        if (_productDetails == null) {
            return new ResponseEntity<ProductDetails>(HttpStatus.NOT_FOUND);
        }

        _productDetails.setProductDetailId(productDetails.getProductDetailId());
        _productDetails.setEntryPrice(productDetails.getEntryPrice());
        _productDetails.setPrice(productDetails.getPrice());
        _productDetails.setQuantity(productDetails.getQuantity());

        productDetailsService.save(_productDetails);
        return new ResponseEntity<ProductDetails>(_productDetails, HttpStatus.OK);
    }


    @DeleteMapping("/productdetail/{id}")
    public ResponseEntity<ProductDetails> deleteProductdDetail(@PathVariable("id") long id) {

        ProductDetails productDetails = productDetailsService.findById(id);
        if (productDetails == null) {
            return new ResponseEntity<ProductDetails>(HttpStatus.NOT_FOUND);
        }

        productDetailsService.remove(id);
        return new ResponseEntity<ProductDetails>(HttpStatus.NO_CONTENT);
    }




}
