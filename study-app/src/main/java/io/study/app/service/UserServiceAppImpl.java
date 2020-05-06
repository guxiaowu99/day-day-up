package io.study.app.service;

import io.study.api.user.dto.UserRegistDTO;
import io.study.api.user.service.UserServiceApi;
import io.study.app.query.UserRegisterQuery;
import io.study.app.util.ModelAppUserConvert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class UserServiceAppImpl {

    @Autowired
    private UserServiceApi userServiceApi;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Boolean register(UserRegisterQuery userRegisterQuery) {
       UserRegistDTO userRegistDTO = ModelAppUserConvert.mapper.mapUserRegistDTO(userRegisterQuery);
       userRegistDTO.setPassword(passwordEncoder.encode(userRegistDTO.getPassword()));
        return userServiceApi.regist(userRegistDTO);
    }
}
