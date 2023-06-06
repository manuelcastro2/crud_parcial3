package com.crud_parcial3.app.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.crud_parcial3.app.Entity.Trabajadores;
import com.crud_parcial3.app.Repository.trabajadoresRepository;

@Service
public class TrabajadoresServiceImpl implements  ITrabajadoresService{

	@Autowired
	private trabajadoresRepository trabajadoresrepository;

	@Override
	@Transactional(readOnly = true)
	public List<Trabajadores> findAll() {
		// TODO Auto-generated method stub
		return (List<Trabajadores>) trabajadoresrepository.findAll();
	}

	@Override
	@Transactional
	public void save(Trabajadores trabajadores) {
		// TODO Auto-generated method stub
		trabajadoresrepository.save(trabajadores);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		trabajadoresrepository.deleteById(id);
	}

	@Override
	public Trabajadores findOne(Long id) {
		// TODO Auto-generated method stub
		return trabajadoresrepository.findById(id).orElse(null);
	}

}
