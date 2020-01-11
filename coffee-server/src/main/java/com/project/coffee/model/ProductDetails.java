package com.project.coffee.model;

import com.project.coffee.config.StringPrefixedSequenceIdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "productDetais")
public class ProductDetails {
    @Id
    @GenericGenerator(name = "id_gen",
            strategy = "com.project.coffee.config.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "00"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "PRODUCTDETAIL_"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d")
            })
    @GeneratedValue(generator = "id_gen")
    private String productDetailId;
    private Long price;
    private Long entryPrice;
    private Long quantity;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne
    @JoinColumn (name = "capacityId")
    private Capacity capacity;

    @ManyToOne
    @JoinColumn (name = "orderDetailId")
    private OrderDetails orderDetails;

    public Capacity getCapacity() {
        return capacity;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(String productDetailId) {
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
