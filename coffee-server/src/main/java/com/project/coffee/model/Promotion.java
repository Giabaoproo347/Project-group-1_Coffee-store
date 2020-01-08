package com.project.coffee.model;

import javax.persistence.*;

@Entity
@Table(name="promotion")

public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long promotionId;
    private String promotionName;
    private Double promotionPrice;
    private boolean promotionStatus;

    public Promotion() {
    }


    public Long getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Long id) {
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
