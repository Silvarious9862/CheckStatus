package com.example.silvarious.CheckStatus.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @RequestMapping("/")
    public String getGreeting() {
        return "Привет! Я тебя знаю! РАБОТАЕТ))))))))))))";
    }
}
