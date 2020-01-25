package com.datacore.ratingserviceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RatingServiceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingServiceServiceApplication.class, args);
	}

}
