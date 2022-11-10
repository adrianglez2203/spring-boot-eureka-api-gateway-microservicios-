package com.springboot.apirest.app.eventos.controllers;

import java.util.List;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.apirest.app.eventos.models.entity.Evento;
import com.springboot.apirest.app.eventos.models.service.IEventoService;
import com.springboot.apirest.app.eventos.response.ResponseHandler;

@RestController
@RequestMapping("/api")
public class EventoController {
	
	@Autowired
	private IEventoService eventoService;
	@GetMapping("/listar")
	public List<Evento> listar(){
		return eventoService.findAll();
	}
	
	@GetMapping("/listar-activos")
	public List<Evento> listarActivos(){
		return eventoService.findByStatus(1);
	}
	@GetMapping("/listar/{id}")
	public ResponseEntity<Object> detalle(@PathVariable Long id) {
		return ResponseHandler.responseBuilder("ok", "asignacion",eventoService.findById(id), HttpStatus.OK);
		
	}
	
	@PostMapping("/crear")
	@ResponseStatus(code = HttpStatus.CREATED )
	public ResponseEntity<Object> crearEvento(@Validated @RequestBody com.fasterxml.jackson.databind.JsonNode payload) throws JsonProcessingException, IllegalArgumentException
	{
		
		
			ObjectMapper mapper = new ObjectMapper();
	        JsonNode node = mapper.valueToTree(payload);
	        JsonNode request = node.get("request");
	        JsonNode evento = request.get("evento");
	    	Evento eventos = mapper.treeToValue(evento, Evento.class);
			eventoService.creaEvento(eventos);
			return ResponseHandler.responseBuilderCreate(eventos, HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Object> eliminarEvento(@PathVariable Long id){
		
		eventoService.eliminaEvento(id);
		return ResponseHandler.responseBuilderDelete(HttpStatus.OK);
		
	}
	@PostMapping("/activar/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Object> activarElemento(@PathVariable Long id){
		eventoService.activarEvento(id);
		return ResponseHandler.responseBuilderActivar(HttpStatus.OK);
	}
//	@PostMapping("/process")
//    public void process(@RequestBody com.fasterxml.jackson.databind.JsonNode payload) throws JsonProcessingException, IllegalArgumentException {
//        ObjectMapper mapper = new ObjectMapper();
//        JsonNode node = mapper.valueToTree(payload);
//        JsonNode request = node.get("request");
//        JsonNode evento = request.get("evento");
//    	Evento eventos = mapper.treeToValue(evento, Evento.class);
//
//
//    }
}
