package com.project.dragon.exception;

import com.project.dragon.enums.ResultEnum;

public class DragonException extends RuntimeException {

    private Integer code;

    public DragonException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public DragonException(Integer code,String message) {
        super(message);
        this.code = code;
    }
}
