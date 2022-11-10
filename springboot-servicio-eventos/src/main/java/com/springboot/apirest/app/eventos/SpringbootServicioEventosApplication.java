package com.springboot.apirest.app.eventos;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class SpringbootServicioEventosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioEventosApplication.class, args);
	}

}
