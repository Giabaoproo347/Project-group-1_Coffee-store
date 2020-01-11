package com.project.coffee.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.coffee.config.StringPrefixedSequenceIdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GenericGenerator(name = "id_gen",
            strategy = "com.project.coffee.config.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "00"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "ORDER_"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d")
            })
    @GeneratedValue(generator = "id_gen")
    private String orderId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate purchaseDate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate deliveryDate;
    private String orderDescription;

    @OneToMany (targetEntity = OrderDetails.class)
    private Set<OrderDetails> orderDetails;

    @ManyToOne
    @JoinColumn (name = "paymentId")
    private Payments payments;

    @ManyToOne
    @JoinColumn (name = "memberId")
    private Members  members;

    public Members getMembers() {
        return members;
    }

    public void setMembers(Members members) {
        this.members = members;
    }

    public Payments getPayments() {
        return payments;
    }

    public void setPayments(Payments payments) {
        this.payments = payments;
    }

    public Set<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }
}
