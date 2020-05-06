/**
 * 
 */
package io.study.app.security.handler;

import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.study.common.model.AuthUser;
import io.study.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * APP环境下认证成功处理器
 * 
 * @author zhangmengchao
 * @date 2020-04-30
 */
@Slf4j
@Component
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired(required = false)
    private ClientDetailsService clientDetailsService;

    @Autowired(required = false)
    private AuthorizationServerTokenServices authorizationServerTokenServices;

    @Autowired(required = false)
    private TokenStore redisTokenStore;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @SuppressWarnings("unchecked")
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
        Authentication authentication) throws IOException, ServletException {
        log.info("登录成功!认证信息：{}", authentication.getPrincipal());

        String header = request.getHeader("Authorization");

        if (header == null) {
            throw new UnapprovedClientAuthenticationException("请求头中无Authorization");
        }

        //保存token,并将失效时间设置为5分钟
        AuthUser authUser = (AuthUser)authentication.getPrincipal();
        Object token = redisTemplate.opsForValue().get(authUser.getId().toString());
        if (Objects.isNull(token)){
            redisTemplate.opsForValue().set(authUser.getId().toString(),
                    UUID.randomUUID().toString(),300,TimeUnit.SECONDS);
        }
        token = redisTemplate.opsForValue().get(authUser.getId().toString());
        //重置失效时间为5分钟
        redisTemplate.expire(authUser.getId().toString(),300,TimeUnit.SECONDS);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(Result.success(token)));

    }
}
