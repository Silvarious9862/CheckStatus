package com.example.silvarious.CheckStatus.config;

import com.example.silvarious.CheckStatus.interceptor.RequestCountInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RequestCountConfig implements WebMvcConfigurer {

    @Autowired
    RequestCountInterceptor requestCountInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestCountInterceptor);
    }
}
