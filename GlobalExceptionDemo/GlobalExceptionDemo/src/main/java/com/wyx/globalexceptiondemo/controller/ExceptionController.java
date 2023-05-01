package com.wyx.globalexceptiondemo.controller;

import com.wyx.globalexceptiondemo.common.exception.AuthException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: GlobalExceptionDemo
 * @BelongsPackage: com.wyx.globalexceptiondemo.controller
 * @Author: Origami
 * @Date: 2023/5/1 21:12
 */
@RestController
public class ExceptionController {

    @GetMapping("runtime")
    public String runtime() {
        throw new RuntimeException();
    }

    @GetMapping("auth")
    public String auth() {
        throw new AuthException();
    }
}
