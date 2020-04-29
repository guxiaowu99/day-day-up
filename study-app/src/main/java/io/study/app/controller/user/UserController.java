package io.study.app.controller.user;

import io.study.app.query.UserRegisterQuery;
import io.study.app.service.UserServiceAppImpl;
import io.study.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(value = "UserController", description = "app端用户接口")
@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserServiceAppImpl userServiceApp;

    @ApiOperation(value = "用户注册接口", httpMethod = "POST")
    @PostMapping("/register")
    public Result<Boolean> register(@RequestBody @Validated UserRegisterQuery userRegisterQuery){

        return Result.success(userServiceApp.register(userRegisterQuery));
    }
}
