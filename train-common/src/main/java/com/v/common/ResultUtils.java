package com.v.common;

/**
 * 返回工具类
 *
 * @author Admin
 * @date 2023/08/11
 */
public class ResultUtils {

    /**
     * 成功
     */
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(200, data, "ok");
    }

    /**
     * 失败
     */
    public static <T> BaseResponse<T> error(ErrorCode errorCode) {
        return new BaseResponse<>(errorCode);
    }

    /**
     * 失败
     */
    public static <T> BaseResponse<T> error(int code, String message) {
        return new <T>BaseResponse<T>(code, null, message);
    }

    /**
     * 失败
     */
    public static <T> BaseResponse<T> error(ErrorCode errorCode, String message) {
        return new <T>BaseResponse<T>(errorCode.getCode(), null, message);
    }
}
