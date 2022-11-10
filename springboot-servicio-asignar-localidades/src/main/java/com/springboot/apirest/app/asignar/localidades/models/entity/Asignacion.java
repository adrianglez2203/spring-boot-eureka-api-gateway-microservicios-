package com.springboot.apirest.app.asignar.localidades.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "asignaciones")
public class Asignacion implements Serializable {

	private static final long serialVersionUID = 6225217491105309021L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
//	@NotBlank
//	@NotNull
	public Long localidad;
	
//	@NotBlank
//	@NotNull
	public Long evento;
	
	@JsonIgnore
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getLocalidad() {
		return localidad;
	}
	public void setLocalidad(Long localidad) {
		this.localidad = localidad;
	}
	public Long getEvento() {
		return evento;
	}
	public void setEvento(Long evento) {
		this.evento = evento;
	}
	@Override
	public String toString() {
		return "Asignacion [id=" + id + ", localidad=" + localidad + ", evento=" + evento + "]";
	}
	public Asignacion(Long localidad, Long evento) {
		super();
		this.localidad = localidad;
		this.evento = evento;
	}
	public Asignacion() {
		super();
	}
	
	
	
	
	
	

}
