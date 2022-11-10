package com.springboot.apirest.app.eventos.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.apirest.app.eventos.models.entity.Evento;

@FeignClient(name = "servicio-evento", url = "localhost:8001")
public interface EventoClienteRest {
	@GetMapping("/listar")
	public List<Evento> listar();
	
	@GetMapping("/listar/{id}")
	public Evento detalle(@PathVariable Long id);

}
