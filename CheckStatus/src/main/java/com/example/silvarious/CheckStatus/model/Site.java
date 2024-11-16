package com.example.silvarious.CheckStatus.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.net.URL;

@Component
public class Site {

    //private String url;
    private String url = "";

    private boolean available = false;

    public Site() {
        this.url = "www";
        this.available = false;
    }

    public Site(Site site) {
        this.url = site.getUrl();
        this.available = site.isAvailable();
    }

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
