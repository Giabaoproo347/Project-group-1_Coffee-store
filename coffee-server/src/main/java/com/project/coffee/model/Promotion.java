package com.project.coffee.model;

import javax.persistence.*;

@Entity
@Table(name="promotion")

public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String namePromotion;
    private Double pricePromotion;
    private String statusPromotion;

    public Promotion() {
    }

    public Promotion(String namePromotion, Double pricePromotion, String statusPromotion) {
        this.namePromotion = namePromotion;
        this.pricePromotion = pricePromotion;
        this.statusPromotion = statusPromotion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamePromotion() {
        return namePromotion;
    }

    public void setNamePromotion(String namePromotion) {
        this.namePromotion = namePromotion;
    }

    public Double getPricePromotion() {
        return pricePromotion;
    }

    public void setPricePromotion(Double pricePromotion) {
        this.pricePromotion = pricePromotion;
    }

    public String getStatusPromotion() {
        return statusPromotion;
    }

    public void setStatusPromotion(String statusPromotion) {
        this.statusPromotion = statusPromotion;
    }
}
