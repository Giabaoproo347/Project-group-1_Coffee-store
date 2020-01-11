package com.project.coffee.service;

import com.project.coffee.model.Members;

public interface MemberService {
    Iterable<Members> findAll();
    Members findById(String id);
    void save (Members members);
    void remove (String id);
}
