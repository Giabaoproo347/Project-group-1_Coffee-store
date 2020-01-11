package com.project.coffee.controller;

import com.project.coffee.model.Categories;
import com.project.coffee.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class CategoriesController {
    @Autowired
    private CategoriesService categoriesService;


    @GetMapping("/categories")
    public ResponseEntity<List<Categories>> listAllCategories() {
        List<Categories> categories =(List<Categories>) categoriesService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<List<Categories>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Categories>>(categories, HttpStatus.OK);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Categories> getCategories(@PathVariable("id") String id) {
        System.out.println("Fetching Categories with id " + id);
        Categories categories = categoriesService.findById(id);
        if (categories == null) {
            System.out.println("Categories with id " + id + " not found");
            return new ResponseEntity<Categories>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Categories>(categories, HttpStatus.OK);
    }

    @PostMapping("/categories")
    public ResponseEntity<Void> createCategories(@RequestBody Categories categories, UriComponentsBuilder ucBuilder) {
        categoriesService.save(categories);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/categories/{id}").buildAndExpand(categories.getCategoryId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<Categories> updateCustomer(@PathVariable("id") String id, @RequestBody Categories categories) {
        System.out.println("Updating Customer " + id);

        Categories currentCategories = categoriesService.findById(id);

        if (currentCategories == null) {
            System.out.println("Categories with id " + id + " not found");
            return new ResponseEntity<Categories>(HttpStatus.NOT_FOUND);
        }

        currentCategories.setCategoryName(categories.getCategoryName());
        currentCategories.setCategoryStatus(categories.getCategoryStatus());
        currentCategories.setCategoryId(categories.getCategoryId());

        categoriesService.save(currentCategories);
        return new ResponseEntity<Categories>(currentCategories, HttpStatus.OK);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Categories> deleteCategories(@PathVariable("id") String id) {
        System.out.println("Fetching & Deleting Categories with id " + id);

        Categories categories = categoriesService.findById(id);
        if (categories == null) {
            System.out.println("Unable to delete. Categories with id " + id + " not found");
            return new ResponseEntity<Categories>(HttpStatus.NOT_FOUND);
        }

        categoriesService.remove(id);
        return new ResponseEntity<Categories>(HttpStatus.NO_CONTENT);
    }
}
