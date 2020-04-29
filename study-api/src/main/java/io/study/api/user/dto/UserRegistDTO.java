package io.study.api.user.dto;

import lombok.Data;

@Data
public class UserRegistDTO {

    /**
     * 用户名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 密码
     */
    private String password;
}
