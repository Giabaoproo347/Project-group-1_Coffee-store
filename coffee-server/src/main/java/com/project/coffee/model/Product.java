package com.project.coffee.model;

import com.project.coffee.config.StringPrefixedSequenceIdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GenericGenerator(name = "id_gen",
            strategy = "com.project.coffee.config.StringPrefixedSequenceIdGenerator",
    parameters = {
            @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "00"),
            @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "PRODUCT_"),
            @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d")
    })
    @GeneratedValue(generator = "id_gen")
    private String productId;
    private String productName;
    private String productDescription;
    private boolean productStatus;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Categories categories;

    @ManyToOne
    @JoinColumn (name = "promotionId")
    private Promotion promotion;

    @OneToMany (targetEntity = ProductDetails.class)
    private Set<ProductDetails> productDetails;

    public Set<ProductDetails> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(Set<ProductDetails> productDetails) {
        this.productDetails = productDetails;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
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
