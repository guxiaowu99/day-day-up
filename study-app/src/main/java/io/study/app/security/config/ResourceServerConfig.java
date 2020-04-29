package io.study.app.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

//    @Autowired
//    private LogoutSuccessHandler etokenLogoutSuccessHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/oauth/toke","/auth/logout","/**/open/**","/actuator/health").permitAll()
                //用户未登录能访问的接口
                .antMatchers("/api/user/register").permitAll()
//                .anyRequest().authenticated()
                .anyRequest().permitAll()
                .and()
                .logout()
                .logoutUrl("/auth/logout")
//                .logoutSuccessHandler(etokenLogoutSuccessHandler)
                .and()
                //关闭跨站请求防护
                .csrf().disable();
    }
}
