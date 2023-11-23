package com.v.train.types.excepiton;


import com.v.train.types.enums.ErrorCode;

/**
 * 自定义异常类
 */
public class BusinessException extends RuntimeException {

    /**
     * 错误码
     */
    private final int code;

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    public BusinessException(ErrorCode errorCode, String message) {
        super(message);
        this.code = errorCode.getCode();
    }

    public BusinessException(ErrorCode errorCode, Exception e) {
        super(e.getMessage());
        this.code = errorCode.getCode();
    }

    public int getCode() {
        return code;
    }
}
