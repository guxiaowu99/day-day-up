package io.study.app.query;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@ApiModel(value = "UserRegisterQuery", description = "用户注册query")
@Data
public class  UserRegisterQuery {

    @NotEmpty(message = "用户名称不能为空")
    private String name;

    @NotEmpty(message = "用户手机号不能为空")
    private String phone;

    @NotEmpty(message = "用户密码不能为空")
    private String password;
}
