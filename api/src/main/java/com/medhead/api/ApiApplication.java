package com.medhead.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.Data;

@Data
@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args)  {
		SpringApplication.run(ApiApplication.class, args);
	}

}
