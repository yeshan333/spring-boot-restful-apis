package com.example.bodymanagement.Enum;

import lombok.Getter;

@Getter
public enum  ResultEnum {

    SUCCESS(10001,"成功"),
    FAILURE(10002,"失败"),
    USER_NEED_AUTHORITIES(20001,"用户未登录"),
    USER_NO_EXIST(20008,"该用户不存在"),
    USER_LOGIN_FAILED(20002,"用户账号或密码错误"),
    USER_LOGIN_SUCCESS(20003,"用户登录成功"),
    USER_NO_ACCESS(20004,"用户无权访问"),
    USER_LOGOUT_SUCCESS(20005,"用户登出成功"),
    TOKEN_IS_BLACKLIST(20006,"此token为黑名单"),
    LOGIN_IS_OVERDUE(20007,"登录已失效"),
    LOGIN_IS_EXIST(20009,"账号已存在"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     *
     *
     * @deprecation:通过code返回枚举
     */
    public static ResultEnum parse(int code){
        ResultEnum[] values = values();
        for (ResultEnum value : values) {
            if(value.getCode() == code){
                return value;
            }
        }
        throw  new RuntimeException("Unknown code of ResultEnum");
    }


}
