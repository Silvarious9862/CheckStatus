package com.example.silvarious.CheckStatus.controller;

import com.example.silvarious.CheckStatus.interceptor.RequestCountInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

@RestController
public class RequestCountController {

    @Autowired
    RequestCountInterceptor requestCountInterceptor;


    @GetMapping("/requestcount")
    public int getRequestCount() {
        return requestCountInterceptor.getCount();
    }
}
