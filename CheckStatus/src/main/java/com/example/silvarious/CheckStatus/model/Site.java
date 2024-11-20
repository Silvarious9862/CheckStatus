package com.example.silvarious.CheckStatus.model;

import jakarta.persistence.*;
import java.net.URL;

@Entity
@Table(name="site_table")
public class Site {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "url")
    private String url = "";

    @Column(name = "available")
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
