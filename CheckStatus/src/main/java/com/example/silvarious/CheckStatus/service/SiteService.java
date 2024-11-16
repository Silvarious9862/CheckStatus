package com.example.silvarious.CheckStatus.service;

import com.example.silvarious.CheckStatus.cache.Cache;
import com.example.silvarious.CheckStatus.model.Site;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Optional;

@Service
public class SiteService {

    Site site = new Site();
    Logger logger = LoggerFactory.getLogger(SiteService.class);

    @Autowired
    private Cache<String, Site> cache;

    public SiteService() { this.site = new Site(); }

    public SiteService(Site site) {
        this.site = site;
    }

    public SiteService(String url) {
        this.site.setUrl(url);
    }

    public Optional<Site> checkSite(String url_str) {

        Site newsite;
        Optional<Site> site = Optional.empty();
        this.site.setUrl(url_str);

        if(cache.containsKey(url_str)) {
            logger.debug("Reply from cache:");
            this.site = cache.get(url_str);
            site = site.of(this.site);
            if(this.site.isAvailable()) logger.info(this.site.getUrl() + " available");
            else logger.warn(this.site.getUrl() + " unavailable");
            return site;
        }

        logger.debug("Get URL: " + url_str);
        try {
            URL url = new URL(this.site.getUrl());
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

        if(!cache.containsKey(url_str)) {
            newsite = new Site(this.site);
            cache.put(url_str, newsite);
        }

        return site;
    }
}
