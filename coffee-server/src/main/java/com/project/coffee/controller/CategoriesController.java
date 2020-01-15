package com.project.coffee.controller;

import com.project.coffee.model.Capacity;
import com.project.coffee.model.Categories;
import com.project.coffee.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/api/category")
public class CategoriesController {
    @Autowired
    private CategoriesService categoriesService;

    @GetMapping("")
    public ResponseEntity<Iterable<Categories>> showListCategories() {
        Iterable<Categories> capacities = categoriesService.findAll();
        return new ResponseEntity<Iterable<Categories>>(capacities, HttpStatus.OK);
    }

    @PostMapping("")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity addNewCategories(@Valid @RequestBody Categories categories) {
        try {
            categoriesService.save(categories);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categories> getCategoryById(@PathVariable String id) {
        Optional<Categories> categories = categoriesService.findById(id);
        if (categories.isPresent()) {
            System.out.println("find Categoties");
            return new ResponseEntity<Categories>(categories.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Categories> updateCategories(@PathVariable String id, @RequestBody Categories categories) {
        Optional<Categories> currentCategory = categoriesService.findById(id);
        if (currentCategory.isPresent()) {
            currentCategory.get().setCategoryId(id);
            currentCategory.get().setCategoryName(categories.getCategoryName());
            currentCategory.get().setCategoryStatus(categories.getCategoryStatus());
            currentCategory.get().setProducts(categories.getProducts());

            categoriesService.save(currentCategory.get());
            return new ResponseEntity<Categories>(currentCategory.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Categories>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Categories> deleteCategories(@PathVariable String id) {
        Optional<Categories> categories = categoriesService.findById(id);
        if (categories.isPresent()) {
            categoriesService.remove(id);
            return new ResponseEntity<Categories>(HttpStatus.OK);
        }
        return new ResponseEntity<Categories>(HttpStatus.NOT_FOUND);
    }
}
