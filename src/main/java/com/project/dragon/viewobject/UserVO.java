package com.project.dragon.viewobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserVO {

    @JsonProperty("id")
    private String userId;

    @JsonProperty("username")
    private String username;

    @JsonProperty("address")
    private String address;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("money")
    private Double money;
}
