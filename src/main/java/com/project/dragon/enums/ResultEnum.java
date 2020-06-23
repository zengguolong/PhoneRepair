package com.project.dragon.enums;

public enum ResultEnum {

    SUCCESS(20000, "成功"),
    PRODUCT_NOT_EXIST(20001, "手机商品信息不存在"),
    USER_NOT_EXIST(20002,"用户不存在"),
    PARAM_ERROR(20003,"参数错误"),
    USER_EXIST(20004,"该用户已注册"),
    ERROR(20005,"用户名或密码错误"),
    QUERY_ERROR(20006,"查询错误"),
    UPDATE_ERROR(20007,"更新失败"),
    DELETE_ERROR(20008,"删除失败"),
    MANAGER_NOT_EXIST(20009,"该手机维修价格信息不存在"),
    NOTICE_NOT_EXIST(20010,"通知信息不存在"),
    USER_NOT_LOGIN(20011,"请先登录"),
    ORDER_NOT_EXIST(20012,"订单信息不存在"),
    BUSINESS_NOT_EXIST(20013,"该营业信息不存在"),
    WORKER_EXIST(20014,"该工人信息已存在"),
    WORKER_NOT_EXIST(20015,"工人信息不存在"),
    PHONE_LABEL_EXIST(20016,"该手机类型已存在"),
    PHONE_LABEL_NOT_EXIST(20016,"改手机类型不存在"),
    ORDER_STATUS(20017,"该订单无法完结"),
    NOT_MONEY(20018,"账户余额不足"),
    ADMIN_LOGIN(20019,"请先进行管理员登录")
    ;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
