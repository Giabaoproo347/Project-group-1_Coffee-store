package com.project.coffee.model;

import com.project.coffee.config.StringPrefixedSequenceIdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GenericGenerator(name = "id_gen",
            strategy = "com.project.coffee.config.StringPrefixedSequenceIdGenerator",
    parameters = {
            @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "00"),
            @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "produc_"),
            @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d")
    })
    @GeneratedValue(generator = "id_gen")
    private String productId;
    private String productName;
    private String productDescription;
    private boolean productStatus;

    public Product() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String id) {
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
