package io.study.common.result;

import io.study.common.exception.SystemErrorEnum;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @author zhangmengchao
 * @date 2020-04-29
 */
@Data
@Slf4j
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1604577017132847751L;
    /**
     * 错误码
     */
    private Integer code;
    /**
     * 是否成功
     */
    private Boolean success;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 具体内容
     */
    private T data;
    /**
     * 时间戳
     */
    private Long timeStamp = System.currentTimeMillis();

    public static Result success(Object data) {
        Result<Object> result = new Result<>();
        result.setCode(200);
        result.setData(data);
        result.setSuccess(Boolean.TRUE);
        return result;
    }

    public static Result success() {
        Result<Object> result = new Result<>();
        result.setCode(200);
        result.setSuccess(Boolean.TRUE);
        return result;
    }

    public static Result error(SystemErrorEnum errorEnum) {
        Result<Object> systemErrorResult = new Result<>();
        systemErrorResult.setCode(errorEnum.getCode());
        systemErrorResult.setMsg(errorEnum.getMsg());
        systemErrorResult.setSuccess(Boolean.FALSE);
        log.error("[错误] 错误信息：{}", systemErrorResult);
        return systemErrorResult;
    }

    public static Result error(Integer code, String msg) {
        Result<Object> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setSuccess(Boolean.FALSE);
        log.error("[错误] 错误信息：{}", result);
        return result;
    }

}
