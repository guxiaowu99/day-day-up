package io.study.app.security;

import io.study.api.user.dto.UserDTO;
import io.study.api.user.service.UserServiceApi;
import io.study.common.exception.ServiceErrorEnum;
import io.study.common.model.AuthUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Auther zhangmengchao
 * @Date 2020/4/29 0029
 */
@Component
@Slf4j
public class AppUserDetailsService implements UserDetailsService{

    @Autowired
    private UserServiceApi userServiceApi;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO userDTO = userServiceApi.selectByName(username);
        if (Objects.isNull(userDTO)){
            throw new UsernameNotFoundException(ServiceErrorEnum.USER_DOES_NOT_EXISTS.getDesc());
        }

        AuthUser authUser = new AuthUser();
        authUser.setId(userDTO.getId());
        authUser.setUsername(userDTO.getName());
        authUser.setPassword(userDTO.getPassword());
        authUser.setPhoneNumber(userDTO.getPhone());
        return null;
    }
}
