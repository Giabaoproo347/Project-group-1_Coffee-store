package com.project.coffee.controller;

import com.project.coffee.model.ProductDetails;
import com.project.coffee.model.Promotion;
import com.project.coffee.service.PromotionService;
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
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/promotion")
public class PromotionController {
    @Autowired
    private PromotionService promotionService;

    @GetMapping("")
    public ResponseEntity<Iterable<Promotion>> showListPromotion() {
        Iterable<Promotion> promotions = promotionService.findAll();
        return new ResponseEntity<Iterable<Promotion>>(promotions, HttpStatus.OK);
    }

    @PostMapping("")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity addNewPromotion(@Valid @RequestBody Promotion promotion) {
        try {
            promotionService.save(promotion);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Promotion> getPromotionById(@PathVariable String id) {
        Optional<Promotion> promotion = promotionService.findById(id);
        if (promotion.isPresent()) {
            System.out.println("find promotion");
            return new ResponseEntity<Promotion>(promotion.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Promotion> updatePromotion(@PathVariable String id, @RequestBody Promotion promotion) {
        Optional<Promotion> currentPromotion = promotionService.findById(id);
        if (currentPromotion.isPresent()) {
            currentPromotion.get().setPromotionId(id);
            currentPromotion.get().setPromotionName(promotion.getPromotionName());
            currentPromotion.get().setPromotionPrice(promotion.getPromotionPrice());
            currentPromotion.get().setPromotionStatus(promotion.getPromotionStatus());
            currentPromotion.get().setProducts(promotion.getProducts());

            promotionService.save(currentPromotion.get());
            return new ResponseEntity<Promotion>(currentPromotion.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Promotion>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Promotion> deletePromotion(@PathVariable String id) {
        Optional<Promotion> promotion = promotionService.findById(id);
        if (promotion.isPresent()) {
            promotionService.remove(id);
            return new ResponseEntity<Promotion>(HttpStatus.OK);
        }
        return new ResponseEntity<Promotion>(HttpStatus.NOT_FOUND);
    }
}
