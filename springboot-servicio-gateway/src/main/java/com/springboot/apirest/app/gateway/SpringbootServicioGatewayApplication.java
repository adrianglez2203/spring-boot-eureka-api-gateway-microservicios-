package com.springboot.apirest.app.gateway;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class SpringbootServicioGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioGatewayApplication.class, args);
	}

}
