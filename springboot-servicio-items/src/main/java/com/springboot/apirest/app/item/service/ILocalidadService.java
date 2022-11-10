package com.springboot.apirest.app.item.service;

import java.util.List;

import org.springframework.stereotype.Component;


import com.springboot.apirest.app.item.models.Localidad;

@Component
public interface ILocalidadService {
	
	public List<Localidad> findAll();
	
	public Localidad findById(Long id);
	
	public Localidad creaLocalidad(Localidad localidad);
	
	public String eliminarLocalidad(Long id);


}
