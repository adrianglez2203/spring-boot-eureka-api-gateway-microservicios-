package com.springboot.apirest.app.asignar.localidades.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.apirest.app.asignar.localidades.clientes.EventoClienteRest;
import com.springboot.apirest.app.asignar.localidades.clientes.LocalizacionesClienteRest;
import com.springboot.apirest.app.asignar.localidades.dao.AsignacionDao;
import com.springboot.apirest.app.asignar.localidades.models.entity.Asignacion;
import com.springboot.apirest.app.asignar.localidades.models.entity.Evento;
import com.springboot.apirest.app.asignar.localidades.models.entity.Localidad;
@Service("serviceFeign")
@Primary
public class AsignacionesServiceFeign implements IAsignacionService {
	@Autowired
	private EventoClienteRest clienteFeign;
	@Autowired(required = true)
	private AsignacionDao asignacionDao;
	@Autowired
	private LocalizacionesClienteRest clienteFeignLoc;
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
		return clienteFeign.listarEventos();
	}

	@Override
	public List<Localidad> findLocalidadesLista() {
		// TODO Auto-generated method stub
		return clienteFeignLoc.listarLocalidades();
	}

}
