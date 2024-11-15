package com.example.silvarious.CheckStatus.config;

import com.example.silvarious.CheckStatus.cache.Cache;
import com.example.silvarious.CheckStatus.model.Site;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    // кэш запросов к сайтам
    @Bean
    public Cache<String, Site> statusCache() { return new Cache<>(); }


}
