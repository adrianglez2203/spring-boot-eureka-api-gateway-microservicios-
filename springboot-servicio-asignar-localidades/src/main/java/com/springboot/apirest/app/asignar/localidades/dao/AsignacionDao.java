package com.springboot.apirest.app.asignar.localidades.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.springboot.apirest.app.asignar.localidades.models.entity.Asignacion;


@Component
public interface AsignacionDao extends CrudRepository<Asignacion, Long>{

	List<Asignacion> findByEvento(Long evento);

}
