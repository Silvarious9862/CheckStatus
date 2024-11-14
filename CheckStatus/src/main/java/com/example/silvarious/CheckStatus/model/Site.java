package com.example.silvarious.CheckStatus.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.net.URL;

@Component
public class Site {

    @NotBlank @org.hibernate.validator.constraints.URL
    private String url;

    private boolean available = false;

    public String getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url.toString();
    }

    public void setUrl(String url) {
        try {
            this.url = url;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
