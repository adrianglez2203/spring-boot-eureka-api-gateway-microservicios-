package com.springboot.apirest.app.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.apirest.app.item.dao.LocalidadDao;
import com.springboot.apirest.app.item.models.Localidad;

@Service
public class LocalidadServicioImplementacion implements ILocalidadService {
	
	@Autowired
	private LocalidadDao localidadDao;
	@Override
	@Transactional(readOnly = true)
	public List<Localidad> findAll() {
		return (List<Localidad>) localidadDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Localidad findById(Long id) {
		return localidadDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Localidad creaLocalidad(@RequestBody Localidad localidad) {
		return localidadDao.save(localidad);
	}

	@Override
	@Transactional
	public String eliminarLocalidad(Long id) {
		localidadDao.deleteById(id);
		return "Ok Localidad Eliminada";
		
	}

}
