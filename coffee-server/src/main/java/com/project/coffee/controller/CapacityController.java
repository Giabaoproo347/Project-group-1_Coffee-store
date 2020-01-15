package com.project.coffee.controller;

import com.project.coffee.model.Capacity;
import com.project.coffee.service.CapacityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/capacity")
public class CapacityController {
    @Autowired
    private CapacityService capacityService;

    @GetMapping("")
    public ResponseEntity<Iterable<Capacity>> showListCapacity() {
        Iterable<Capacity> capacities = capacityService.findAll();
        return new ResponseEntity<Iterable<Capacity>>(capacities, HttpStatus.OK);
    }

    @PostMapping("")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity addNewCapacity(@Valid @RequestBody Capacity capacity) {
        try {
            capacityService.save(capacity);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Capacity> getCapacityById(@PathVariable String id) {
        Optional<Capacity> capacity = capacityService.findById(id);
        if (capacity.isPresent()) {
            System.out.println("find Capacity");
            return new ResponseEntity<Capacity>(capacity.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Capacity> updateCapacity(@PathVariable String id, @RequestBody Capacity capacity) {
        Optional<Capacity> currentCapacity = capacityService.findById(id);
        if (currentCapacity.isPresent()) {
            currentCapacity.get().setCapacityId(id);
            currentCapacity.get().setCapacityName(capacity.getCapacityName());
            currentCapacity.get().setCapacityValue(capacity.getCapacityValue());
            currentCapacity.get().setProductDetails(capacity.getProductDetails());

            capacityService.save(currentCapacity.get());
            return new ResponseEntity<Capacity>(currentCapacity.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Capacity>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Capacity> deleteCapacity(@PathVariable String id) {
        Optional<Capacity> capacity = capacityService.findById(id);
        if (capacity.isPresent()) {
            capacityService.remove(id);
            return new ResponseEntity<Capacity>(HttpStatus.OK);
        }
        return new ResponseEntity<Capacity>(HttpStatus.NOT_FOUND);
    }
}

