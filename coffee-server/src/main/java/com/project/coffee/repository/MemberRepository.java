package com.project.coffee.repository;

import com.project.coffee.model.Members;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Members, String> {
}
