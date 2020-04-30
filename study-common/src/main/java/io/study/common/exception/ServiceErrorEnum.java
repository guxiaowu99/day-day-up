package io.study.common.exception;

import lombok.Getter;

/**
 * @Auther zhangmengchao
 * @Date 2020/4/29 0029
 */
@Getter
public enum ServiceErrorEnum {

    /**
     * 账号不存在
     */
    USER_DOES_NOT_EXISTS(20100,"User does not exists", "用户账号不存在"),

    /**
     * 用户已被禁用
     */
    USER_DISABLED(20101,"User disable", "用户已被禁用"),

    /**
     * 账号已被锁定
     */
    USER_LOCKED(20102,"User locked", "账号已被锁定"),

    /**
     * 账号和密码不匹配
     */
    INVALID_PASSWORD(20103,"Username or password error", "用户名或密码不匹配"),
    ;

    /**
     * 错误代码
     */
    private int code;

    /**
     * 错误信息
     */
    private String msg;

    /**
     * 详细描述
     */
    private String desc;

    ServiceErrorEnum(int code, String msg, String desc){
        this.code = code;
        this.msg = msg;
        this.desc = desc;
    }

    public static ServiceErrorEnum getByCode(Integer code){
        for (ServiceErrorEnum serviceErrorEnum : ServiceErrorEnum.values()){
            if (serviceErrorEnum.getCode() == code){
                return serviceErrorEnum;
            }
        }
        return null;
    }
}
