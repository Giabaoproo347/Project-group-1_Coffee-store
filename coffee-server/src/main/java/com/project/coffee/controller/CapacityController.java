package com.project.coffee.controller;

import com.project.coffee.model.Capacity;
import com.project.coffee.service.CapacityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
public class CapacityController {
    @Autowired
    private CapacityService capacityService;

    @RequestMapping(value = "/capacity", method = RequestMethod.GET)
    public ResponseEntity<List<Capacity>> listCapacity(){
        List<Capacity> capacities = (List<Capacity>) capacityService.findAll();
        if(capacities.isEmpty()){
            return new ResponseEntity<List<Capacity>>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<List<Capacity>>(HttpStatus.OK);
        }
    }

@RequestMapping(value = "/capacity/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Capacity> getCapacity(@PathVariable("id") long id){
        Capacity capacity = capacityService.findById(id);
        if(capacity == null){
            return new ResponseEntity<Capacity>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Capacity>(capacity, HttpStatus.OK);
        }
}

@RequestMapping(value = "/capacity", method = RequestMethod.POST)
    public ResponseEntity<Capacity> createCapacity(@RequestBody Capacity capacity, UriComponentsBuilder ucBuilder){
        capacityService.save(capacity);
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(ucBuilder.path("/capacity").buildAndExpand(capacity.getCapacityId()).toUri());
    return new ResponseEntity<Capacity>(headers, HttpStatus.CREATED);
}
 @RequestMapping(value = "/capacity/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Capacity> updateCapacity(@RequestBody Capacity capacity, @PathVariable("id") Long id){
        Capacity capacity1 = capacityService.findById(id);
        if(capacity1 == null){
            System.out.println(" khong tin thay phan tu can sua");
            return new ResponseEntity<Capacity>(HttpStatus.NOT_FOUND);
        }else{
            capacity1.setCapacityId(capacity.getCapacityId());
            capacity1.setCapacityname(capacity.getCapacityname());
            capacity1.setCapacityValue(capacity.getCapacityValue());
            return new ResponseEntity<Capacity>(capacity1, HttpStatus.OK);
        }
 }

@RequestMapping(value = "/capacity/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Capacity> deleteCapacity(@PathVariable("id") Long id){
        Capacity _capacity = capacityService.findById(id);
        if(_capacity == null){
            System.out.println("khong ton tai phan tu can xoa");
            return new ResponseEntity<Capacity>(HttpStatus.NOT_FOUND);
        }else{
            capacityService.remove(id);
            return new ResponseEntity<Capacity>(HttpStatus.NO_CONTENT);
        }

}



}
