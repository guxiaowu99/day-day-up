/**
 * 
 */
package io.study.app.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.study.common.exception.ServiceErrorEnum;
import io.study.common.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * APP环境下认证失败处理器
 *
 * @author zhangmengchao
 * @date 2020-04-30
 */
@Component
public class AuthenctiationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

		logger.info("[用户认证] 登录失败, 异常信息：{}", exception);

		Result result;

		if (exception instanceof DisabledException) {
			result = Result.error(ServiceErrorEnum.USER_DISABLED.getCode(), ServiceErrorEnum.USER_DISABLED.getDesc());
		} else if (exception instanceof LockedException) {
			result = Result.error(ServiceErrorEnum.USER_LOCKED.getCode(), ServiceErrorEnum.USER_LOCKED.getDesc());
		} else {
			result = Result.error(ServiceErrorEnum.INVALID_PASSWORD.getCode(), ServiceErrorEnum.INVALID_PASSWORD.getDesc());
		}
		response.setStatus(HttpStatus.OK.value());
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(objectMapper.writeValueAsString(result));
		
	}

}
