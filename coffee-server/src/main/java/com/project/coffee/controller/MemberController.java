package com.project.coffee.controller;

import com.project.coffee.model.Members;
import com.project.coffee.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin( origins = "*", maxAge = 3600)
@RequestMapping("/api/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("")
    public ResponseEntity<Iterable<Members>> showListMembers() {
        Iterable<Members> members = memberService.findAll();
        return new ResponseEntity<Iterable<Members>>(members, HttpStatus.OK);
    }

    @PostMapping("")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity addNewMember(@Valid @RequestBody Members members) {
        try {
            memberService.save(members);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Members> getMemberById(@PathVariable String id) {
        Optional<Members> members = memberService.findById(id);
        if (members.isPresent()) {
            System.out.println("find Members");
            return new ResponseEntity<Members>(members.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Members> updateMembers(@PathVariable String id, @RequestBody Members members) {
        Optional<Members> currentMember = memberService.findById(id);
        if (currentMember.isPresent()) {
            currentMember.get().setMemberId(id);
            currentMember.get().setMemberName(members.getMemberName());
            currentMember.get().setEmail(members.getEmail());
            currentMember.get().setPassword(members.getPassword());
            currentMember.get().setGender(members.isGender());
            currentMember.get().setMemberDOB(members.getMemberDOB());
            currentMember.get().setMemberPhone(members.getMemberPhone());
            currentMember.get().setMemberAddress(members.getMemberAddress());
            currentMember.get().setMemberStatus(members.isMemberStatus());
            currentMember.get().setMemberStatus(members.isMemberStatus());
            currentMember.get().setOrders(members.getOrders());

            memberService.save(currentMember.get());
            return new ResponseEntity<Members>(currentMember.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Members>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Members> deleteMembers(@PathVariable String id) {
        Optional<Members> members = memberService.findById(id);
        if (members.isPresent()) {
            memberService.remove(id);
            return new ResponseEntity<Members>(HttpStatus.OK);
        }
        return new ResponseEntity<Members>(HttpStatus.NOT_FOUND);
    }
}
