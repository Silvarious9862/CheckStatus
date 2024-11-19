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

    public Site checkSite(String url_str) {

        Site newsite;
        Site site = new Site();
        site.setUrl(url_str);

        if(cache.containsKey(url_str)) {
            logger.debug("Reply from cache:");
            site = cache.get(url_str);
            if(site.isAvailable()) logger.info(site.getUrl() + " available");
            else logger.warn(site.getUrl() + " unavailable");
            return site;
        }

        logger.debug("Get URL: " + url_str);
        try {
            URL url = new URL(site.getUrl());
            URLConnection urlConnection = url.openConnection();
            logger.debug("Connecting to " + url.toString() + "...");
            if(urlConnection.getContent() != null) {
                logger.info(url.toString() + " available");
                site.setAvailable(true);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            logger.warn(url_str + " unavailable");
            site.setAvailable(false);
        }


        if(!cache.containsKey(url_str)) {
            newsite = new Site(site);
            cache.put(url_str, newsite);
        }

        return site;
    }

    public static String toString(Site site) {
        String availableString = new String();
        if (site.isAvailable()) availableString = " available";
        else availableString = " NOT available";
        return (site.getUrl() + availableString);
    }
}
