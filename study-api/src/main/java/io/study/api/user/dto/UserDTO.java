package io.study.api.user.dto;

import lombok.Data;

/**
 * @Auther zhangmengchao
 * @Date 2020/4/29 0029
 */
@Data
public class UserDTO {

    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户名称
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
