package com.springboot.apirest.app.asignar.localidades.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.apirest.app.asignar.localidades.models.entity.Asignacion;
import com.springboot.apirest.app.asignar.localidades.models.entity.Evento;
import com.springboot.apirest.app.asignar.localidades.models.entity.Localidad;


@Component
public interface IAsignacionService {
	
	public List<Asignacion> findAll();
	
	public Asignacion findById(Long id);
	
	public Asignacion save(Asignacion asignacion);
	
	public String deleteById(Long id);
	
	public List<Evento> findEventosActivos();
	
	public List<Localidad> findLocalidadesLista();
}
