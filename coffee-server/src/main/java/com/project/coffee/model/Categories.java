package com.project.coffee.model;

import javax.persistence.*;

@Entity
@Table(name="categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryId;
    private String categoryName;
    private String categoryStatus;

    public Categories() {
    }

    public Categories(String categoryName, String categoryStatus) {
        this.categoryName = categoryName;
        this.categoryStatus = categoryStatus;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoriesId) {
        this.categoryId = categoriesId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoriesName) {
        this.categoryName = categoriesName;
    }

    public String getCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(String categoriesStatus) {
        this.categoryStatus = categoriesStatus;
    }
}
