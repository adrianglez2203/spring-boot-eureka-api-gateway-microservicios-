package com.springboot.apirest.app.asignar.localidades.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.apirest.app.asignar.localidades.models.entity.Asignacion;
import com.springboot.apirest.app.asignar.localidades.models.entity.Evento;
import com.springboot.apirest.app.asignar.localidades.models.entity.Localidad;
import com.springboot.apirest.app.asignar.localidades.response.ResponseHandler;
import com.springboot.apirest.app.asignar.localidades.services.IAsignacionService;

@RestController
@RequestMapping("/api")
public class AsignacionController {
	
	
	
	@Autowired
	@Qualifier("serviceFeign")
	private IAsignacionService asignacionService;
	
	@GetMapping("/listar")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Asignacion> listar(){
		return asignacionService.findAll();
		
	}
	@GetMapping("/listar/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Object> detalle(@PathVariable Long id) {
		return ResponseHandler.responseBuilder("ok", "asignacion", asignacionService.findById(id), HttpStatus.OK);
		
	}
	@PostMapping("/crear")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Object> crear(
			@Validated @RequestBody  com.fasterxml.jackson.databind.JsonNode payload) throws JsonProcessingException, IllegalArgumentException {
			
			ObjectMapper mapper = new ObjectMapper();
		    JsonNode node = mapper.valueToTree(payload);
		    JsonNode request = node.get("request");
		    JsonNode localidad = request.get("localidad");
		    JsonNode evento = request.get("evento");
			Localidad localidades = mapper.treeToValue(localidad, Localidad.class);	
			Evento eventos = mapper.treeToValue(evento, Evento.class);
			Long eventoRequest = eventos.getId();
			Long localidadRequest = localidades.getId();
			List<Evento> eventosActivos = asignacionService.findEventosActivos();
			List<Localidad> localidadesDisponibles = asignacionService.findLocalidadesLista();
			Boolean existeEvento = false;
			Boolean existeLocalidad = false;
			for (Evento i : eventosActivos) {
				if(i.getId()==eventoRequest) {
					existeEvento = true;
				}
			}
			for (Localidad j : localidadesDisponibles) {
				if (j.getId() == localidadRequest) {
					existeLocalidad = true;
				}
			}
			if (existeEvento == true && existeLocalidad == true) {
				Asignacion asignacion = new Asignacion(eventoRequest, localidadRequest);
				asignacionService.save(asignacion);
				return ResponseHandler.responseBuilderCreate(asignacionService.save(asignacion), HttpStatus.CREATED);
			}
			else {
				return ResponseHandler.responseBuilderCreateNegation( existeEvento, existeLocalidad);
			}
			
	}
	
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Object> eliminar(@PathVariable Long id) {
		asignacionService.deleteById(id);
		return ResponseHandler.responseBuilderDelete(HttpStatus.OK);
	}
}
