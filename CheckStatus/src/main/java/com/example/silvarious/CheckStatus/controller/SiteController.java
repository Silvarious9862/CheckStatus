package com.example.silvarious.CheckStatus.controller;

import com.example.silvarious.CheckStatus.model.Site;
import com.example.silvarious.CheckStatus.service.SiteService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class SiteController {
    private SiteService siteService;

    @Autowired
    public SiteController(SiteService siteService) {
        this.siteService = siteService;
    }

    @GetMapping("/status")
    public Site checkSite(@RequestParam @Pattern(regexp = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]") String url) {
        Optional<Site> site = siteService.checkSite(url);
        return (Site) site.orElse(null);
    }
}
