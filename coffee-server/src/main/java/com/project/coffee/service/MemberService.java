package com.project.coffee.service;

import com.project.coffee.model.Members;

import java.util.Optional;

public interface MemberService {
    Iterable<Members> findAll();
    Optional<Members> findById(String id);
    void save (Members members);
    void remove (String id);
}
