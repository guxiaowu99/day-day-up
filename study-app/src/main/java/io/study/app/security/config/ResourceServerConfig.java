package io.study.app.security.config;

import io.study.app.security.handler.AuthenctiationFailureHandler;
import io.study.app.security.handler.AuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 * 资源权限设置
 *
 * @Auther zhangmengchao
 * @Date 2020/4/29 0029
 */
@Configuration
@EnableWebSecurity
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenctiationFailureHandler authenctiationFailureHandler;

    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.formLogin()
                .loginProcessingUrl("/auth/form")  //设置登录处理url
                .successHandler(authenticationSuccessHandler) // 设置自定义成功处理器
                .failureHandler(authenctiationFailureHandler) // 设置自定义失败处理器
                .and()
                .authorizeRequests()     // 身份认证设置
                .antMatchers("/signin.html").permitAll() //该路由不需要身份认账
                .antMatchers("/auth/*","/api/user/register").permitAll() //该路由不需要身份认账
                .anyRequest()       //其他的路由均需要身份认证
                .authenticated()
                .and()
                .csrf()
                .disable();   //先禁用防止跨站脚本攻击的csrf token
    }
}
