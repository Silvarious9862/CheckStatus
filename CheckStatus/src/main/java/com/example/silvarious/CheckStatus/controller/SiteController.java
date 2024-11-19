package com.example.silvarious.CheckStatus.controller;

import com.example.silvarious.CheckStatus.model.Site;
import com.example.silvarious.CheckStatus.service.SiteService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class SiteController {
    private SiteService siteService;
    Logger logger
            = LoggerFactory.getLogger(SiteController.class);

    @Autowired
    public SiteController(SiteService siteService) {
        this.siteService = siteService;
    }

    @GetMapping("/status")
    public Site checkSite(@RequestParam @Pattern(regexp = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]") String url) {
        return /*site = */ siteService.checkSite(url);
        //return site;
    }

    @PostMapping("/status")
    public ResponseEntity<?> listOfSites(@RequestBody List<String> listSites) {

        List<String> responseList = listSites.stream()
                .map(this::checkSite)
                .map(SiteService::toString)
                .collect(Collectors.toList());

        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }
}
