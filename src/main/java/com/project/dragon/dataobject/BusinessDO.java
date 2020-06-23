package com.project.dragon.dataobject;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BusinessDO {

    @Id
    private String id;

    private Integer orderNumber;

    private Double amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}