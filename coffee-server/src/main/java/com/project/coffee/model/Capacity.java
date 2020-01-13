package com.project.coffee.model;

import com.project.coffee.config.StringPrefixedSequenceIdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "capacity")
public class Capacity {
    @Id
    @GenericGenerator(name = "id_gen",
            strategy = "com.project.coffee.config.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "00"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "CAPACITY_"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d")
            })
    @GeneratedValue(generator = "id_gen")
    private String capacityId;
    private String capacityName;
    private Long capacityValue;

    public Set<ProductDetails> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(Set<ProductDetails> productDetails) {
        this.productDetails = productDetails;
    }

    @OneToMany (targetEntity = ProductDetails.class)
    private Set<ProductDetails> productDetails;

    public String getCapacityId() {
        return capacityId;
    }

    public void setCapacityId(String capacityId) {
        this.capacityId = capacityId;
    }

    public String getCapacityName() {
        return capacityName;
    }

    public void setCapacityName(String capacityname) {
        this.capacityName = capacityname;
    }

    public Long getCapacityValue() {
        return capacityValue;
    }

    public void setCapacityValue(Long capacityValue) {
        this.capacityValue = capacityValue;
    }
}
