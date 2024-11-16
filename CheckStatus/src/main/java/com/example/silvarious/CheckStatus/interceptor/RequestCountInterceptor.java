package com.example.silvarious.CheckStatus.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class RequestCountInterceptor implements HandlerInterceptor {

    int count = 0;
    Logger logger = LoggerFactory.getLogger(RequestCountInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            logger.debug("preHandle. Method Type: " + request.getMethod() + " | Request URL: " + request.getRequestURI());
            count++;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        try {
            logger.debug("postHandle.");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //* Business logic after request and response is Completed
        try {
            logger.debug("afterCompletion. Request Count:" + getCount());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getCount() {
        return count;
    }
}
