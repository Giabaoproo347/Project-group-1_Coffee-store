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

    @RequestMapping(value = "/promotion/", method = RequestMethod.GET)
    public ResponseEntity<List<Promotion>> listAllPromotion() {
        List<Promotion> promotions =(List<Promotion>) promotionService.findAll();
        if (promotions.isEmpty()) {
            return new ResponseEntity<List<Promotion>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Promotion>>(promotions, HttpStatus.OK);
    }

    @RequestMapping(value = "/promotion/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Promotion> getProduct(@PathVariable("id") long id) {
        Promotion promotion = promotionService.findById(id);
        if (promotion == null) {
            return new ResponseEntity<Promotion>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Promotion>(promotion, HttpStatus.OK);
    }

    @RequestMapping(value = "/promotion/", method = RequestMethod.POST)
    public ResponseEntity<Void> createPromotion(@RequestBody Promotion promotion, UriComponentsBuilder ucBuilder) {
        promotionService.save(promotion);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/promotion/{id}").buildAndExpand(promotion.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/promotion/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Promotion> updatePromotion(@PathVariable("id") long id, @RequestBody Promotion promotion) {

        Promotion currenPromotion = promotionService.findById(id);

        if (currenPromotion == null) {
            return new ResponseEntity<Promotion>(HttpStatus.NOT_FOUND);
        }

        currenPromotion.setNamePromotion(promotion.getNamePromotion());
        currenPromotion.setPricePromotion(promotion.getPricePromotion());
        currenPromotion.setStatusPromotion(promotion.getStatusPromotion());
        currenPromotion.setId(promotion.getId());

        promotionService.save(currenPromotion);
        return new ResponseEntity<Promotion>(currenPromotion, HttpStatus.OK);
    }


    @RequestMapping(value = "/promotion/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Promotion> deletePromotion(@PathVariable("id") long id) {

        Promotion promotion = promotionService.findById(id);
        if (promotion == null) {
            return new ResponseEntity<Promotion>(HttpStatus.NOT_FOUND);
        }

        promotionService.remove(id);
        return new ResponseEntity<Promotion>(HttpStatus.NO_CONTENT);
    }
}
