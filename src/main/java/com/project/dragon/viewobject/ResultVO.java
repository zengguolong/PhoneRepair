package com.project.dragon.viewobject;

public class ResultVO<T> {

    //错误码
    private int code;

    //提示信息
    private String message;

    //返回的具体数据
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
