package com.project.coffee.service;

import com.project.coffee.model.Members;

public interface MemberService {
    Iterable<Members> findAll();
    Members findById(Long id);
    void save (Members members);
    void remove (Long id);
}
