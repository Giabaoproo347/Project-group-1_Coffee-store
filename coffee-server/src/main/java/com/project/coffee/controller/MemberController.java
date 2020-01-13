package com.project.coffee.controller;

import com.project.coffee.model.Members;
import com.project.coffee.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/members")
    public ResponseEntity<List<Members>> listAllMembers() {
        List<Members> members = (List<Members>) memberService.findAll();
        if (members.isEmpty()) {
            return new ResponseEntity<List<Members>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Members>>(HttpStatus.OK);
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<Members> getMember(@PathVariable String id) {
        Members members = memberService.findById(id);
        if (members == null) {
            return new ResponseEntity<Members>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Members>(members, HttpStatus.OK);
    }

    @PostMapping("/members")
    public ResponseEntity<Void> createMember(@RequestBody Members members, UriComponentsBuilder ucBuider) {
        memberService.save(members);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuider.path("/members{id}").buildAndExpand(members.getMemberId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/members/{id}")
    public ResponseEntity<Members> updateMember(@PathVariable String id, @RequestBody Members members) {
        Members currentMember = memberService.findById(id);

        if (currentMember == null) {
            return new ResponseEntity<Members>(HttpStatus.NOT_FOUND);
        }

        currentMember.setMemberId(members.getMemberId());
        currentMember.setEmail(members.getEmail());
        currentMember.setGender(members.isGender());
        currentMember.setMemberAddress(members.getMemberAddress());
        currentMember.setMemberDOB(members.getMemberDOB());
        currentMember.setMemberName(members.getMemberName());
        currentMember.setMemberPhone(members.getMemberPhone());
        currentMember.setMemberStatus(members.isMemberStatus());
        currentMember.setPassword(members.getPassword());

        memberService.save(currentMember);
        return new ResponseEntity<Members>(currentMember, HttpStatus.OK);
    }
}
