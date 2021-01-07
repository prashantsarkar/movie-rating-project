package com.prashant.moviecatalogservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
	
	@LoadBalanced
	@Bean
	public WebClient.Builder getWebClientBuilder() {
		return WebClient.builder();
	}
}
