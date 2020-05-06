package io.study.common.enums;

import lombok.Getter;

/**
 * 用户状态枚举
 */
@Getter
public enum UserStatusEnum {

    /**
     * 正常
     */
    NORMAL(0,"正常"),
    /**
     * 禁用
     */
    DISABLED(1,"禁用"),
    /**
     * 锁定
     */
    LOCKED(2,"锁定"),
    ;

    private int status;
    private String desc;

    UserStatusEnum(Integer status, String desc){
        this.status = status;
        this.desc = desc;
    }
}
