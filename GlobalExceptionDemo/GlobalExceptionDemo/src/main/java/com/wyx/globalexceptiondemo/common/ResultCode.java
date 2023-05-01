package com.wyx.globalexceptiondemo.common;

/**
 * @BelongsProject: GlobalExceptionDemo
 * @BelongsPackage: com.wyx.globalexceptiondemo.common
 * @Author: Origami
 * @Date: 2023/5/1 21:28
 */
public enum ResultCode implements ErrCode {
    /**
     * SUCCESS: 操作成功
     * FAILED: 操作失败
     * VALIDATE_FAILED: 参数校验失败
     * UNAUTHORIZED: 暂未登录或token已过期
     * FORBIDDEN: 没有相关权限
     */
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(501, "参数校验失败"),
    UNAUTHORIZED(502, "暂未登录或token已过期"),
    FORBIDDEN(503, "没有相关权限"),
    FILE_TRANSFER_EXCEPTION(504, "文件传输失败"),
    CUSTOMIZED_EXCEPTION(505, "自定义异常类错误"),
    UNKNOWN_EXCEPTION(520, "未知异常");

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    private final long code;
    private final String message;

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return message;
    }
}
