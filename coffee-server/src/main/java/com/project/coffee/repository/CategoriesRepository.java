package com.project.coffee.repository;

import com.project.coffee.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories,String> {
}
