package com.github.manojesus.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MovieCatalogServiceApplication {
	@Bean
	@LoadBalanced //this annotation will tell rest template to use eureka instead of searching for the url, it will look at services registered in eureka-server
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}

}
