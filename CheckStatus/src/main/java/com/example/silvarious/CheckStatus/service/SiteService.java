package com.example.silvarious.CheckStatus.service;

import com.example.silvarious.CheckStatus.model.Site;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.Optional;

@Service
public class SiteService {
    Site site;

    public SiteService(Site site) {
        this.site = site;
    }

    public Optional<Site> checkSite(String url_str) {
        Optional<Site> site = Optional.empty();
        this.site.setUrl(url_str);
        try {
            URL url = new URL(url_str);
            URLConnection urlConnection = url.openConnection();
            if(urlConnection.getContent() != null) {
                this.site.setAvailable(true);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            this.site.setAvailable(false);
        }
        site = site.of(this.site);
        return site;
    }
}
