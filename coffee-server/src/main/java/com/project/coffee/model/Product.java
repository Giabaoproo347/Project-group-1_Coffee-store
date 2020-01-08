package com.project.coffee.model;

import javax.persistence.*;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    private String productName;
    private String productDescription;
    private boolean productStatus;

    public Product() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long id) {
        this.productId = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String nameProduct) {
        this.productName = nameProduct;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String descriptionProduct) {
        this.productDescription = descriptionProduct;
    }

    public boolean getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean statusProduct) {
        this.productStatus = statusProduct;
    }
}
