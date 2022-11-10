package com.springboot.apirest.app.eventos.models.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.apirest.app.eventos.models.entity.Evento;
@Component
public interface IEventoService {
	
	
	public List<Evento> findAll();

	public Evento findById(Long id);
	public Evento creaEvento(Evento evento);
	
	public String eliminaEvento(Long id);
	public String activarEvento(Long id);
	List<Evento> findByStatus(Integer status);
}