package com.project.coffee.service.impl;

import com.project.coffee.model.Members;
import com.project.coffee.repository.MemberRepository;
import com.project.coffee.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Iterable<Members> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Optional<Members> findById(String id) {
        return memberRepository.findById(id);
    }


    @Override
    public void save(Members members) {
        memberRepository.save(members);
    }

    @Override
    public void remove(String id) {
        memberRepository.deleteById(id);
    }
}
