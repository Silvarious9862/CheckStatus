package com.example.silvarious.CheckStatus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication

public class CheckStatusApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckStatusApplication.class, args);
	}

}
