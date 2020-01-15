package com.project.coffee.model;

import com.project.coffee.config.StringPrefixedSequenceIdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="promotion")

public class Promotion {
    @Id
    @GenericGenerator(name = "id_gen",
            strategy = "com.project.coffee.config.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "00"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "PROMOTION_"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d")
            })
    @GeneratedValue(generator = "id_gen")
    private String promotionId;
    private String promotionName;
    private Double promotionPrice;
    private boolean promotionStatus;

    @OneToMany (targetEntity = Product.class)
    private Set<Product> products;

    public Promotion() {
    }

    public Promotion(String promotionId, String promotionName, Double promotionPrice, boolean promotionStatus, Set<Product> products) {
        this.promotionId = promotionId;
        this.promotionName = promotionName;
        this.promotionPrice = promotionPrice;
        this.promotionStatus = promotionStatus;
        this.products = products;
    }

    public boolean isPromotionStatus() {
        return promotionStatus;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(String id) {
        this.promotionId = id;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String namePromotion) {
        this.promotionName = namePromotion;
    }

    public Double getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(Double pricePromotion) {
        this.promotionPrice = pricePromotion;
    }

    public boolean getPromotionStatus() {
        return promotionStatus;
    }

    public void setPromotionStatus(boolean statusPromotion) {
        this.promotionStatus = statusPromotion;
    }
}
