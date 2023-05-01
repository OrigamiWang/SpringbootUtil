package com.wyx.globalexceptiondemo.common.exception;

/**
 * @BelongsProject: GlobalExceptionDemo
 * @BelongsPackage: com.wyx.globalexceptiondemo.common.exception
 * @Author: Origami
 * @Date: 2023/5/1 21:41
 */
public class AuthException extends RuntimeException {
    private final String msg;

    public AuthException() {
        msg = "未登录，无访问权限！";
    }

    public AuthException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
