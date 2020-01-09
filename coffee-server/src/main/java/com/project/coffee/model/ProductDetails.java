package com.project.coffee.model;

import javax.persistence.*;

@Entity
@Table(name = "db_productdetails")
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productDetailId;
    @Column
    private Long price;
    @Column
    private Long entryPrice;
    @Column
    private Long quantity;

    public Long getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(Long productDetailId) {
        this.productDetailId = productDetailId;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getEntryPrice() {
        return entryPrice;
    }

    public void setEntryPrice(Long entryPrice) {
        this.entryPrice = entryPrice;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
