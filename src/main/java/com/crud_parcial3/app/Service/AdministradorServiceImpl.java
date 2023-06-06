package com.crud_parcial3.app.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.crud_parcial3.app.Entity.Administrador;
import com.crud_parcial3.app.Repository.administradorRepository;


@Service
public class AdministradorServiceImpl implements IAdministradorService{
	
	@Autowired
	private administradorRepository administracionrepository;

	@Override
	@Transactional(readOnly = true)
	public List<Administrador> findAll() {
		// TODO Auto-generated method stub
		return (List<Administrador>) administracionrepository.findAll();
	}

	@Override
	@Transactional
	public void save(Administrador administrador) {
		// TODO Auto-generated method stub
		administracionrepository.save(administrador);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		administracionrepository.deleteById(id);
	}

	@Override
	public Administrador findOne(Long id) {
		// TODO Auto-generated method stub
		return administracionrepository.findById(id).orElse(null);
	}

}
