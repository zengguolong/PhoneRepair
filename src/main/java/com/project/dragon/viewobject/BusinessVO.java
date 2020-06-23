package com.project.dragon.viewobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BusinessVO {

    @JsonProperty("orderTotal")
    private Integer orderTotal;

    @JsonProperty("orderAmount")
    private Double  orderAmount;
}
