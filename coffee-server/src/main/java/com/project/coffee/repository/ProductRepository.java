package com.project.coffee.repository;

import com.project.coffee.model.Categories;
import com.project.coffee.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String> {
    Page<Product> findAllByCategories (Categories categories, Pageable pageable);

}
