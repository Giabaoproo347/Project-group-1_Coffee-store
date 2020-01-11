package com.project.coffee.repository;

import com.project.coffee.model.Capacity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CapacityRepository extends JpaRepository<Capacity, String> {

}
