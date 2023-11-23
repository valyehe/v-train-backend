package com.v.train.exception;


import com.v.train.types.enums.ErrorCode;
import com.v.train.types.excepiton.BusinessException;
import com.v.train.types.model.BaseResponse;
import com.v.train.types.util.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author Admin
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public BaseResponse<?> businessExceptionHandler(BusinessException e) {
        log.error("BusinessException", e);
        return ResultUtils.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public BaseResponse<?> runtimeExceptionHandler(RuntimeException e) {
        log.error("RuntimeException", e);
        return ResultUtils.error(ErrorCode.SYSTEM_ERROR, "系统错误");
    }

    @ExceptionHandler(BindException.class)
    public BaseResponse<?> BindExceptionHandler(BindException e) {
        log.error("BusinessException", e);
        return ResultUtils.error(ErrorCode.SYSTEM_ERROR, e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }
}
