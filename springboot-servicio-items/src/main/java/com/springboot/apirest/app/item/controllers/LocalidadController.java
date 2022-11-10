package com.springboot.apirest.app.item.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.springboot.apirest.app.item.models.Localidad;
import com.springboot.apirest.app.item.response.ResponseHandler;
import com.springboot.apirest.app.item.service.ILocalidadService;

@RestController
@RequestMapping("/api")
public class LocalidadController {
	
	@Autowired
	private ILocalidadService localidadService;
	
	@GetMapping("/listar")
	public List<Localidad> listar(){
		return localidadService.findAll();
	}
	@GetMapping("/listar/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public ResponseEntity<Object> detalle(@PathVariable Long id) {
	
	     return ResponseHandler.responseBuilder("ok", "localidad", localidadService.findById(id), HttpStatus.ACCEPTED);
	 
	}

	@PostMapping("/crear")
	@ResponseStatus(code = HttpStatus.CREATED )
	public ResponseEntity<Object> crearLocalidad(@Validated @RequestBody  com.fasterxml.jackson.databind.JsonNode payload) throws JsonProcessingException, IllegalArgumentException

	{
		ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.valueToTree(payload);
        JsonNode request = node.get("request");
        JsonNode localidad = request.get("localidad");
    	Localidad localidades = mapper.treeToValue(localidad, Localidad.class);	
		localidadService.creaLocalidad(localidades);
		return ResponseHandler.responseBuilderCreate(localidad, HttpStatus.CREATED);
		
	}
}	
