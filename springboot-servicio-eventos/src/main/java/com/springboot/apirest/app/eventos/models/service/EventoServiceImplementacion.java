package com.springboot.apirest.app.eventos.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.springboot.apirest.app.eventos.models.dao.EventoDao;
import com.springboot.apirest.app.eventos.models.entity.Evento;


@Service
public class EventoServiceImplementacion implements IEventoService{
	
	@Autowired
	private EventoDao eventoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Evento> findAll() {

		return (List<Evento>) eventoDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Evento findById(Long id) {

		return eventoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Evento creaEvento(Evento evento) {
		
		return eventoDao.save(evento);
	}

	@Override
	@Transactional
	public String eliminaEvento(Long id) {
		try {
			if ( eventoDao.existsById(id)){
				
				Optional<Evento> evento = eventoDao.findById(id);
				Evento evento_request = evento.get(); 
				if (evento_request.getStatus() == 1) {
					evento_request.setStatus(2);
					return "Ok";
				}
				else {
					throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Ese elemento ya esta desactivado");
				}
				
			}
			else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"El elemento ya esta desactivado");
			}
			
		} catch (ResponseStatusException e) {
			throw new ResponseStatusException(e.getStatus(), e.getMessage());
		}
	}

	@Override
	@Transactional
	public String activarEvento(Long id) {
		try {
			if ( eventoDao.existsById(id)){
				
				Optional<Evento> evento = eventoDao.findById(id);
				Evento evento_request = evento.get(); 
				if (evento_request.getStatus() == 2) {
					evento_request.setStatus(1);
					return "Ok";
				}
				else {
					throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Ese elemento ya esta activado");
				}
			}
			else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No existe es elemento");
			}
			
		} catch (ResponseStatusException e) {
			throw new ResponseStatusException(e.getStatus(), e.getMessage());
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Evento> findByStatus(Integer status) {
		return (List<Evento>) eventoDao.findByStatus(status);
	}

}
