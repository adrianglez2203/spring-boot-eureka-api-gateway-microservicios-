package com.springboot.apirest.app.eventos.response;



import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
	public static ResponseEntity<Object> responseBuilderCreate(
			Object responseObject,
			HttpStatus httpStatus
	){
		Map<String, Object> response = new HashMap<>();
		response.put("response", "Ok");
		response.put("evento", responseObject);
	    return new ResponseEntity<>(response, httpStatus);

	}
	public static ResponseEntity<Object> responseBuilderDelete(HttpStatus httpStatus){
		Map<String, Object> response = new HashMap<>();
		response.put("response", "Ok");
		return new ResponseEntity<>(response,httpStatus );
	}
	public static ResponseEntity<Object> responseBuilderActivar(HttpStatus httpStatus){
		Map<String, Object> response = new HashMap<>();
		response.put("response", "Ok Evento Activado");
		return new ResponseEntity<>(response,httpStatus );
	}
	
	
}

