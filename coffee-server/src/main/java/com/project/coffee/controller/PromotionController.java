package com.project.coffee.controller;

import com.project.coffee.model.Promotion;
import com.project.coffee.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class PromotionController {
    @Autowired
    private PromotionService promotionService;

    @GetMapping("/promotion")
    public ResponseEntity<List<Promotion>> listAllPromotion() {
        List<Promotion> promotions =(List<Promotion>) promotionService.findAll();
        if (promotions.isEmpty()) {
            return new ResponseEntity<List<Promotion>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Promotion>>(promotions, HttpStatus.OK);
    }

    @GetMapping("/promotion/{id}")
    public ResponseEntity<Promotion> getProduct(@PathVariable("id") String id) {
        Promotion promotion = promotionService.findById(id);
        if (promotion == null) {
            return new ResponseEntity<Promotion>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Promotion>(promotion, HttpStatus.OK);
    }

    @PostMapping("/promotion")
    public ResponseEntity<Void> createPromotion(@RequestBody Promotion promotion, UriComponentsBuilder ucBuilder) {
        promotionService.save(promotion);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/promotion/{id}").buildAndExpand(promotion.getPromotionId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


    @PutMapping("/promotion/{id}")
    public ResponseEntity<Promotion> updatePromotion(@PathVariable("id") String id, @RequestBody Promotion promotion) {

        Promotion currenPromotion = promotionService.findById(id);

        if (currenPromotion == null) {
            return new ResponseEntity<Promotion>(HttpStatus.NOT_FOUND);
        }

        currenPromotion.setPromotionName(promotion.getPromotionName());
        currenPromotion.setPromotionPrice(promotion.getPromotionPrice());
        currenPromotion.setPromotionStatus(promotion.getPromotionStatus());
        currenPromotion.setPromotionId(promotion.getPromotionId());

        promotionService.save(currenPromotion);
        return new ResponseEntity<Promotion>(currenPromotion, HttpStatus.OK);
    }


    @DeleteMapping("/promotion/{id}")
    public ResponseEntity<Promotion> deletePromotion(@PathVariable("id") String id) {

        Promotion promotion = promotionService.findById(id);
        if (promotion == null) {
            return new ResponseEntity<Promotion>(HttpStatus.NOT_FOUND);
        }

        promotionService.remove(id);
        return new ResponseEntity<Promotion>(HttpStatus.NO_CONTENT);
    }
}
