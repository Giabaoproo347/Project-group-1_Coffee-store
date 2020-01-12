package com.project.coffee.repository;

import com.project.coffee.model.Categories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories,String> {
    Page<Categories> findAllByCategoryNameContaining (String categoryName, Pageable pageable);
}
