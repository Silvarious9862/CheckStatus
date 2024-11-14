package com.example.silvarious.CheckStatus.service;

import com.example.silvarious.CheckStatus.controller.LogController;
import com.example.silvarious.CheckStatus.model.Site;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.Optional;

@Service
public class SiteService {
    Site site;
    Logger logger
            = LoggerFactory.getLogger(SiteService.class);

    public SiteService() { this.site = new Site(); }

    public SiteService(Site site) {
        this.site = site;
    }

    public SiteService(String url) {
        this.site.setUrl(url);
    }

    public Optional<Site> checkSite(String url_str) {
        Optional<Site> site = Optional.empty();
        this.site.setUrl(url_str);
        logger.debug("Get URL: " + url_str);
        try {
            URL url = new URL(url_str);
            URLConnection urlConnection = url.openConnection();
            logger.debug("Connecting to " + url.toString() + "...");
            if(urlConnection.getContent() != null) {
                logger.info(url.toString() + " available");
                this.site.setAvailable(true);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            logger.warn(url_str + " unavailable");
            this.site.setAvailable(false);
        }
        site = site.of(this.site);
        return site;
    }
}
