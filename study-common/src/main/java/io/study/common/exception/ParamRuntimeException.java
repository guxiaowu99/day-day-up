package io.study.common.exception;


/**
 * @author zhangmengchao
 * @date 2020-04-29
 */
public class ParamRuntimeException extends RuntimeException {

    /**
     * 异常编码
     */
    private Integer code;
    /**
     * 异常信息
     */
    private String msg;

    public ParamRuntimeException(String message) {
        super(message);
        this.code = SystemErrorEnum.PARAM_ERROR.getCode();
        this.msg = message;
    }

    public ParamRuntimeException(Integer code, String message) {
        super(message);
        this.code = code;
        this.msg = message;
    }

}
