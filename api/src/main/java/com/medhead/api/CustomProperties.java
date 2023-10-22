package com.medhead.api;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix="com.medhead.api")
public class CustomProperties {
	
	private String apiKey;
	
}
