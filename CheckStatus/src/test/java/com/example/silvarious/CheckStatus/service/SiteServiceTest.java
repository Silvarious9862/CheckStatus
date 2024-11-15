package com.example.silvarious.CheckStatus.service;

import com.example.silvarious.CheckStatus.cache.Cache;
import com.example.silvarious.CheckStatus.model.Site;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class SiteServiceTest {

    @Mock
    private Cache<String, Site> cache;

    @InjectMocks
    private SiteService siteService = new SiteService();

    @Test
    void checkSiteTrueTest() {
        Mockito.when(cache.containsKey("http://youtube.com")).thenReturn(false);

        Optional<Site> result = siteService.checkSite("http://youtube.com");
        Site resultSite = result.get();

        Assertions.assertTrue(resultSite.isAvailable());

    }

    @Test
    void checkSiteFalseTest() {
        Mockito.when(cache.containsKey("http://youtube.code")).thenReturn(false);

        Optional<Site> result = siteService.checkSite("http://youtube.code");
        Site resultSite = result.get();

        Assertions.assertFalse(resultSite.isAvailable());
    }

    @Test
    void checkSiteCacheTest() {
        String url = "http://youtube.com";
        Site site = getSite(url);

        Mockito.when(cache.containsKey(url)).thenReturn(true);
        Mockito.when(cache.get(url)).thenReturn(site);

        Optional<Site> result = siteService.checkSite(url);
        Site resultSite = result.get();

        Assertions.assertTrue(resultSite.isAvailable());
    }

    private Site getSite(String url) {
        Site site = new Site();
        site.setUrl(url);
        site.setAvailable(true);
        return site;
    }

}