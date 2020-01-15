package com.project.coffee.model;

import com.project.coffee.config.StringPrefixedSequenceIdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="categories")
public class Categories {
    @Id
    @GenericGenerator(name = "id_gen",
            strategy = "com.project.coffee.config.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "00"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "CATEGORY_"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d")
            })
    @GeneratedValue(generator = "id_gen")
    private String categoryId;
    private String categoryName;
    private boolean categoryStatus;

    @OneToMany(targetEntity = Product.class, fetch = FetchType.EAGER)
    private Set<Product> products;

    public Categories() {
    }

    public Categories(String categoryId, String categoryName, boolean categoryStatus, Set<Product> products) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryStatus = categoryStatus;
        this.products = products;
    }

    public boolean isCategoryStatus() {
        return categoryStatus;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoriesId) {
        this.categoryId = categoriesId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoriesName) {
        this.categoryName = categoriesName;
    }

    public boolean getCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(boolean categoriesStatus) {
        this.categoryStatus = categoriesStatus;
    }
}
