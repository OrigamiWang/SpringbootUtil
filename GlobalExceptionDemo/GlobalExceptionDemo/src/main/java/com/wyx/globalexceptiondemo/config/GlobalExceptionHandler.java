package com.wyx.globalexceptiondemo.config;

import com.wyx.globalexceptiondemo.common.CommonResult;
import com.wyx.globalexceptiondemo.common.ResultCode;
import com.wyx.globalexceptiondemo.common.exception.AuthException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @BelongsProject: GlobalExceptionDemo
 * @BelongsPackage: com.wyx.globalexceptiondemo.config
 * @Author: Origami
 * @Date: 2023/5/1 21:12
 */
@ControllerAdvice
public class GlobalExceptionHandler {


    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public CommonResult<RuntimeException> handleRuntimeException(RuntimeException runtimeException) {
        runtimeException.printStackTrace();
        return CommonResult.customizedException(ResultCode.UNKNOWN_EXCEPTION.getCode(), "未知运行时异常");
    }


    @ResponseBody
    @ExceptionHandler(AuthException.class)
    public CommonResult<RuntimeException> handleUnAuthorized(RuntimeException runtimeException) {
        runtimeException.printStackTrace();
        return CommonResult.customizedException(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMsg());
    }


}
