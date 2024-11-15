package com.example.silvarious.CheckStatus.service;

import com.example.silvarious.CheckStatus.model.Site;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class SiteServiceTest {

    @Test
    void checkSiteTrueTest() {
        SiteService siteService = new SiteService();
        Optional<Site> result = siteService.checkSite("http://youtube.com");
        Site resultSite = result.get();

        Assertions.assertTrue(resultSite.isAvailable());

    }@Test
    void checkSiteFalseTest() {
        SiteService siteService = new SiteService();
        Optional<Site> result = siteService.checkSite("http://youtube.code");
        Site resultSite = result.get();

        Assertions.assertFalse(resultSite.isAvailable());
    }

}