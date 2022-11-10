package com.springboot.apirest.app.asignar.localidades.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.apirest.app.asignar.localidades.models.entity.Localidad;

@FeignClient(name = "servicio-localidad")
public interface LocalizacionesClienteRest {
	
	@GetMapping("/api/listar")
	public List<Localidad> listarLocalidades();
	
}
