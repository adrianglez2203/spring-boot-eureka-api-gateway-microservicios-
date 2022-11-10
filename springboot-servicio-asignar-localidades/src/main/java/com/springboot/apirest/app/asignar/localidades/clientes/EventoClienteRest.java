package com.springboot.apirest.app.asignar.localidades.clientes;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.apirest.app.asignar.localidades.models.entity.Evento;



@FeignClient(name = "servicio-evento")
public interface EventoClienteRest {
	
	@GetMapping("/api/listar")
	public List<Evento> listarEventos();
}