package io.study.app.service;

import io.study.api.user.dto.UserRegistDTO;
import io.study.api.user.service.UserServiceApi;
import io.study.app.query.UserRegisterQuery;
import io.study.app.util.ModelAppUserConvert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceAppImpl {

    @Autowired
    private UserServiceApi userServiceApi;

    public Boolean register(UserRegisterQuery userRegisterQuery) {
       UserRegistDTO userRegistDTO = ModelAppUserConvert.mapper.mapUserRegistDTO(userRegisterQuery);
        return userServiceApi.regist(userRegistDTO);
    }
}
