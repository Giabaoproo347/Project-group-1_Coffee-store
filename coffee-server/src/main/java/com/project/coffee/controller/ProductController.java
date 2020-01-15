package com.project.coffee.controller;


import com.project.coffee.model.Categories;
import com.project.coffee.model.Product;

import com.project.coffee.repository.ProductRepository;
import com.project.coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin( origins = "*", maxAge = 3600)
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    ProductRepository productRepository;

    @Autowired
    Environment env;

    @GetMapping("")
    public ResponseEntity<List<Product>> listAllProducts() {
        List<Product> products = (List<Product>) productService.findAll();
        if (products.isEmpty()) {
            return new ResponseEntity<List<Product>>(products, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getProduct(@PathVariable("id") String id) {
        System.out.println("Fetching Product with id " + id);
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()) {
            System.out.println("Product with id " + id + " not found");
            return new ResponseEntity<Optional<Product>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Optional<Product>>(product, HttpStatus.OK);
    }

    @PostMapping("")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Optional<Product>> createProduct(@RequestBody Product product) {
        System.out.println("Creating Product " + product.getProductName());
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        Product currentProduct = new Product(product.getProductName(), product.getProductStatus(), product.getProductImage(), product.getProductPrice(), product.getProductDescription(), product.getProductStatus(), product.getCategories(), product.getPromotion());
        productService.save(currentProduct);
        return new ResponseEntity<Optional<Product>>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Optional<Product>> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        System.out.println("Updating Product " + id);

        Optional<Product> currentProduct = productService.findById(id);

        if (!currentProduct.isPresent()) {
            System.out.println("Product with id " + id + " not found");
            return new ResponseEntity<Optional<Product>>(HttpStatus.NOT_FOUND);
        }
        currentProduct.get().setProductName(product.getProductName());
        currentProduct.get().setProductImage(product.getProductImage());
        currentProduct.get().setProductPrice(product.getProductPrice());
        currentProduct.get().setProductPrice(product.getProductPrice());
        currentProduct.get().setProductImage(product.getProductImage());
        currentProduct.get().setProductDescription(product.getProductDescription());
        currentProduct.get().setProductStatus(product.getProductStatus());
        currentProduct.get().setCategories(product.getCategories());
        currentProduct.get().setPromotion(product.getPromotion());
        currentProduct.get().setProductDetails(product.getProductDetails());

        productService.save(currentProduct.get());
        return new ResponseEntity<Optional<Product>>(currentProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") String id) {
        System.out.println("Fetching & Deleting Product with id " + id);

        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()) {
            System.out.println("Unable to delete. Product with id " + id + " not found");
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }

        productService.remove(id);
        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
    }
}
