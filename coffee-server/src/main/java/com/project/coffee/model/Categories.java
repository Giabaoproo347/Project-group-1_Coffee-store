package com.project.coffee.model;

import javax.persistence.*;

@Entity
@Table(name="categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoriesId;
    private String categoriesName;
    private String categoriesStatus;

    public Categories() {
    }

    public Categories(String categoriesName, String categoriesStatus) {
        this.categoriesName = categoriesName;
        this.categoriesStatus = categoriesStatus;
    }

    public Long getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(Long categoriesId) {
        this.categoriesId = categoriesId;
    }

    public String getCategoriesName() {
        return categoriesName;
    }

    public void setCategoriesName(String categoriesName) {
        this.categoriesName = categoriesName;
    }

    public String getCategoriesStatus() {
        return categoriesStatus;
    }

    public void setCategoriesStatus(String categoriesStatus) {
        this.categoriesStatus = categoriesStatus;
    }
}
