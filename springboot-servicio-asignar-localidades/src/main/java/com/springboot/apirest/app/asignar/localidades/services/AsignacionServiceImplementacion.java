package com.springboot.apirest.app.asignar.localidades.services;

import java.util.Arrays;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.springboot.apirest.app.asignar.localidades.dao.AsignacionDao;
import com.springboot.apirest.app.asignar.localidades.models.entity.Asignacion;
import com.springboot.apirest.app.asignar.localidades.models.entity.Evento;
import com.springboot.apirest.app.asignar.localidades.models.entity.Localidad;
@Service
public class AsignacionServiceImplementacion implements IAsignacionService{
	
	
	@Autowired(required = true)
	private AsignacionDao asignacionDao;
	
	@Autowired
	private RestTemplate clienteRest;
	
	@Override
	@Transactional(readOnly = true)
	public List<Asignacion> findAll() {

		return (List<Asignacion>) asignacionDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Asignacion findById(Long id) {

		return asignacionDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Asignacion save(Asignacion asignacion) {
//	    List<Asignacion> asignacion_search = asignacionDao.findByEvento(asignacion.evento);
	    
		return asignacionDao.save(asignacion);
	}

	@Override
	@Transactional
	public String deleteById(Long id) {

		asignacionDao.deleteById(id);
		return "Ok";
		
	}

	@Override
	public List<Evento> findEventosActivos() {
		List<Evento> eventos = Arrays.asList(clienteRest.getForObject("http://localhost:8001/api/listar-activos", Evento[].class));
		return eventos;
	}
	@Override
	public List<Localidad> findLocalidadesLista(){
		List<Localidad> localidades = Arrays.asList(clienteRest.getForObject("http://localhost:8002/api/listar", Localidad[].class));
		return localidades;
	}
}
