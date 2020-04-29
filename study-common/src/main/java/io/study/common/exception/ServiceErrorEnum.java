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
    USER_DOES_NOT_EXISTS(20100,"User does not exists", "用户账号不存在")
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
