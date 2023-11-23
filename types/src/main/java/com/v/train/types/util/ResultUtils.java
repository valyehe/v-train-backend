package com.v.train.types.util;


import com.v.train.types.enums.ErrorCode;
import com.v.train.types.model.BaseResponse;

/**
 * 返回工具类
 */
public class ResultUtils {

    /**
     * 成功
     */
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(200, data, "ok");
    }

    /**
     * 成功
     */
    public static <T> BaseResponse<T> success(String message) {
        return new <T>BaseResponse<T>(200, null, message);
    }

    /**
     * 失败
     */
    public static <T> BaseResponse<T> error(ErrorCode errorCode) {
        return new <T>BaseResponse<T>(errorCode);
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

    /**
     * 失败
     */
    public static <T> BaseResponse<T> error(int code, T data, String message) {
        return new <T>BaseResponse<T>(code, data, message);
    }


}
