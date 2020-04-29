package io.study.common.exception;


import lombok.Data;

/**
 * @author zhangmengchao
 * @date 2020-04-29
 */
@Data
public class BizRuntimeException extends RuntimeException {

    /**
     * 异常编码
     */
    private Integer code;
    /**
     * 异常信息
     */
    private String msg;

    public BizRuntimeException(SystemErrorEnum errorEnum) {
        super(errorEnum.getMsg());
        this.code = errorEnum.getCode();
        this.msg = errorEnum.getDesc();
    }

    public BizRuntimeException(SystemErrorEnum errorEnum, Throwable cause) {
        super(errorEnum.getMsg(), cause);
        this.code = errorEnum.getCode();
        this.msg = errorEnum.getDesc();
    }

    public BizRuntimeException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BizRuntimeException(Integer code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
        this.msg = msg;
    }

}
