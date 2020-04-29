package io.study.api.user.service;

import io.study.api.user.dto.UserDTO;
import io.study.api.user.dto.UserRegistDTO;

public interface UserServiceApi {

    /**
     * 用户注册接口
     * @param userRegistDTO
     * @return
     */
    Boolean regist(UserRegistDTO userRegistDTO);

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    UserDTO selectByName(String username);
}
