package com.project.dragon.viewobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductVO {

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("image")
    private String productImage;

    @JsonProperty("type")
    private String productType;


}
