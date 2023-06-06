package com.crud_parcial3.app.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crud_parcial3.app.Entity.Trabajadores;

@Service
public interface ITrabajadoresService {
	
	public List<Trabajadores> findAll();

	public void save(Trabajadores trabajadores);

	public void delete(Long id);

	public Trabajadores findOne(Long id);

}
