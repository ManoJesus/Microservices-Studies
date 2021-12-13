package com.github.manojesus.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCircuitBreaker
public class MovieCatalogServiceApplication {
	@Bean
	@LoadBalanced //this annotation will tell rest template to use eureka instead of searching for the url, it will look at services registered in eureka-server
	public RestTemplate getRestTemplate(){
		/*
		Here We are adding TimeOut to the RestTemplate requests, but it partly solves the problem, since if requests came faster than the timeout the app is going to face the same issue
		*/
		HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		httpComponentsClientHttpRequestFactory.setConnectTimeout(10000);
		return new RestTemplate(httpComponentsClientHttpRequestFactory);
	}
	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}

}
