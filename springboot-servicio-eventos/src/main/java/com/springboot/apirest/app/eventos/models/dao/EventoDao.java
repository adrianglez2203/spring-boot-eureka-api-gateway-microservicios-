package com.springboot.apirest.app.eventos.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.springboot.apirest.app.eventos.models.entity.Evento;
@Component
public interface EventoDao extends CrudRepository<Evento, Long> {
	
	List<Evento> findByStatus(Integer status);
	
}
