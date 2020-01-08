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


    @RequestMapping(value = "/categories/", method = RequestMethod.GET)
    public ResponseEntity<List<Categories>> listAllCategories() {
        List<Categories> categories =(List<Categories>) categoriesService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<List<Categories>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Categories>>(categories, HttpStatus.OK);
    }

    @RequestMapping(value = "/categories/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Categories> getCategories(@PathVariable("id") long id) {
        System.out.println("Fetching Categories with id " + id);
        Categories categories = categoriesService.findById(id);
        if (categories == null) {
            System.out.println("Categories with id " + id + " not found");
            return new ResponseEntity<Categories>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Categories>(categories, HttpStatus.OK);
    }

    @RequestMapping(value = "/categories/", method = RequestMethod.POST)
    public ResponseEntity<Void> createCategories(@RequestBody Categories categories, UriComponentsBuilder ucBuilder) {
        categoriesService.save(categories);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/categories/{id}").buildAndExpand(categories.getCategoriesId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/categories/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Categories> updateCustomer(@PathVariable("id") long id, @RequestBody Categories categories) {
        System.out.println("Updating Customer " + id);

        Categories currentCategories = categoriesService.findById(id);

        if (currentCategories == null) {
            System.out.println("Categories with id " + id + " not found");
            return new ResponseEntity<Categories>(HttpStatus.NOT_FOUND);
        }

        currentCategories.setCategoriesName(categories.getCategoriesName());
        currentCategories.setCategoriesStatus(categories.getCategoriesStatus());
        currentCategories.setCategoriesId(categories.getCategoriesId());

        categoriesService.save(currentCategories);
        return new ResponseEntity<Categories>(currentCategories, HttpStatus.OK);
    }


    @RequestMapping(value = "/categories/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Categories> deleteCategories(@PathVariable("id") long id) {
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
