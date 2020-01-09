package com.project.coffee.model;

import javax.persistence.*;

@Entity
@Table(name = "db_capacity")
public class Capacity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long capacityId;
    @Column
    private String capacityname;
    @Column
    private Long capacityValue;

    public Long getCapacityId() {
        return capacityId;
    }

    public void setCapacityId(Long capacityId) {
        this.capacityId = capacityId;
    }

    public String getCapacityname() {
        return capacityname;
    }

    public void setCapacityname(String capacityname) {
        this.capacityname = capacityname;
    }

    public Long getCapacityValue() {
        return capacityValue;
    }

    public void setCapacityValue(Long capacityValue) {
        this.capacityValue = capacityValue;
    }
}
