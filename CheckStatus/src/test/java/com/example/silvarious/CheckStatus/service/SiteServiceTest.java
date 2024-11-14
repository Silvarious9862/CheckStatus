package com.example.silvarious.CheckStatus.service;

import com.example.silvarious.CheckStatus.model.Site;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;


public class SiteServiceTest {

    private SiteService siteService = new SiteService("http://www.youtube.com");

    @Test
    public void shouldAvailable() {
        Optional<Site> result = siteService.checkSite("http://www.youtube.com");
        Site site = result.get();
        Assertions.assertEquals("http://www.youtube.com", site.getUrl());
        Assertions.assertTrue(site.isAvailable());
    }
}
