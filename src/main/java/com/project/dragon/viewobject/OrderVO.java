package com.project.dragon.viewobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OrderVO {

    @JsonProperty("name")
    private String orderUsername;

    @JsonProperty("phone")
    private String orderPhone;

    @JsonProperty("money")
    private Double orderAmount;

    @JsonProperty("detail")
    private String orderDetail;

    @JsonProperty("order_status")
    private String orderStatus;

    @JsonProperty("order_time")
    private String orderTime;

    @JsonProperty("order_remark")
    private String orderRemark;
}
