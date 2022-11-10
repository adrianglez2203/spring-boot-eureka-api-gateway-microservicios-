package com.springboot.apirest.app.asignar.localidades;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@SpringBootApplication
public class SpringbootServicioAsignarLocalidadesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioAsignarLocalidadesApplication.class, args);
	}

}
