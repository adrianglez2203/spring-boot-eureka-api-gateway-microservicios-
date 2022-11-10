package com.springboot.apirest.app.asignar.localidades.models.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Localidad {
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	private Long id;
	private String nombre;
}
