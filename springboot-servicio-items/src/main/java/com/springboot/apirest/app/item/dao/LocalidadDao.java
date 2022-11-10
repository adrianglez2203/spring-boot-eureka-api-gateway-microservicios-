package com.springboot.apirest.app.item.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.springboot.apirest.app.item.models.Localidad;



@Component
public interface LocalidadDao extends CrudRepository<Localidad, Long> {

}
