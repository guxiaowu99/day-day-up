package io.study.common.exception;

import lombok.Getter;

/**
 * 系统级错误
 *
 * eg:10002
 * 1	                     00	          02
 * 系统级错误（2为服务级错误）	服务模块代码	具体错误代码
 *
 * @author zhangmengchao
 * @date 2020-04-29
 */
@Getter
public enum SystemErrorEnum {

    /** 系统错误 */
    SYSTEM_ERROR(10001, "System error", "系统错误"),

    /** 服务暂停 */
    SERVICE_UNAVAILABLE(10002, "Service unavailable", "服务暂停"),

    /** 远程服务错误 */
    REMOTE_SERVICE_ERROR(10003, "Remote service error", "远程服务错误"),

    /** IP限制不能请求该资源 */
    IP_LIMIT(10004, "IP limit", "IP限制不能请求该资源"),

    /** 任务过多，系统繁忙 */
    SYSTEM_BUSY(10005, "Too many pending tasks, system is busy", "任务过多，系统繁忙"),

    /** 接口不存在 */
    API_NOT_FOUND(10006, "Request api not found", "接口不存在"),

    /** 参数错误，请参考API文档 */
    PARAM_ERROR(10007, "Param error, see doc for more info", "参数错误，请参考API文档"),

    /** RPC错误 */
    RPC_ERROR(10008, "RPC error", "RPC错误"),

    /** 非法请求 */
    ILLEGAL_REQUEST(10009, "Illegal request", "非法请求"),

    /** 任务超时 */
    JOB_EXPIRED(10010, "Job expired", "任务超时"),

    /** 网络超时 */
    NET_EXPIRED(10011, "Net expired", "网络繁忙，请稍后再试！"),

    ;

    /** 错误代码 */
    private int code;

    /** 错误信息 */
    private String msg;

    /** 详细描述 */
    private String desc;

    SystemErrorEnum(int code, String msg, String desc) {
        this.code = code;
        this.msg = msg;
        this.desc = desc;
    }

    public static SystemErrorEnum getByCode(Integer code) {
        for(SystemErrorEnum systemErrorEnum : SystemErrorEnum.values()) {
            if(systemErrorEnum.getCode() == code) {
                return systemErrorEnum;
            }
        }
        return null;
    }
}
