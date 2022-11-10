package com.springboot.apirest.app.asignar.localidades.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.springboot.apirest.app.asignar.localidades.models.entity.Evento;

public class ResponseHandler {
	
	public static ResponseEntity<Object> responseBuilder(
			String message1, 
			String message2, 
			Object responseObject,
			HttpStatus httpStatus
	)
	{
		
		Map<String, Object> response = new HashMap<>();
		response.put("response", message1);
		response.put(message2, responseObject);
	    return new ResponseEntity<>(response, httpStatus);

		
	}
	
	public static ResponseEntity<Object> responseBuilderDelete(HttpStatus httpStatus){
		Map<String, Object> response = new HashMap<>();
		response.put("response", "Ok");
		return new ResponseEntity<>(response,httpStatus );
	}
	public static ResponseEntity<Object> responseBuilderCreate(
			Object responseObject,
			HttpStatus httpStatus
	){
		Map<String, Object> response = new HashMap<>();
		response.put("response", "Ok");
		response.put("evento", responseObject);
	    return new ResponseEntity<>(response, httpStatus);

	}
	public static ResponseEntity<Object> responseBuilderCreateNegation(
			 Boolean existeEvento, Boolean existeLocalidad
	){
		
		Map<String, Object> response = new HashMap<>();
		
		if (existeEvento == false) {
			
			response.put("evento", "El evento no esta activo o no existe");
			
		}
		if (existeLocalidad == false) {
			response.put("localidad", "La locacion escogida no existe");
		}
	    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

	}
	
}
