package com.v.train.types.enums;

/**
 * 自定义错误码
 *
 * @author Admin
 * date 2023/08/21
 */
public enum ErrorCode {

    SUCCESS(200, "ok"),
    PARAMS_ERROR(40000, "请求参数错误"),
    NOT_LOGIN_ERROR(40100, "未登录"),
    NO_AUTH_ERROR(40101, "无权限"),
    NOT_FOUND_ERROR(40400, "请求数据不存在"),

    /**
     * 40001 数据为空
     */
    NULL_ERROR(40001, "请求数据为空"),

    TOO_MANY_REQUEST(42900, "请求过于频繁"),

    FORBIDDEN_ERROR(40300, "禁止访问"),
    SYSTEM_ERROR(50000, "系统内部异常"),
    OPERATION_ERROR(50001, "操作失败"),

    /**
     * 业务逻辑
     */
    MEMBER_MOBILE_EXIST(40000, "手机号已注册"),
    MEMBER_MOBILE_NOT_EXIST(40000, "请先获取短信验证码"),
    MEMBER_MOBILE_CODE_ERROR(40000, "短信验证码错误"),

    BUSINESS_STATION_NAME_UNIQUE_ERROR(40000, "车站已存在"),
    BUSINESS_TRAIN_CODE_UNIQUE_ERROR(40000, "车次编号已存在"),
    BUSINESS_TRAIN_STATION_INDEX_UNIQUE_ERROR(40000, "同车次站序已存在"),
    BUSINESS_TRAIN_STATION_NAME_UNIQUE_ERROR(40000, "同车次站名已存在"),
    BUSINESS_TRAIN_CARRIAGE_INDEX_UNIQUE_ERROR(40000, "同车次厢号已存在"),

    CONFIRM_ORDER_TICKET_COUNT_ERROR(50000, "余票不足"),
    CONFIRM_ORDER_EXCEPTION(42900, "服务器忙，请稍候重试"),
    CONFIRM_ORDER_LOCK_FAIL(42900, "当前抢票人数过多，请稍候重试"),
    CONFIRM_ORDER_FLOW_EXCEPTION(42900, "当前抢票人数太多了，请稍候重试"),
    CONFIRM_ORDER_SK_TOKEN_FAIL(42900, "当前抢票人数过多，请5秒后重试"),
    ;

    /**
     * 状态码
     */
    private final int code;

    /**
     * 信息
     */
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
