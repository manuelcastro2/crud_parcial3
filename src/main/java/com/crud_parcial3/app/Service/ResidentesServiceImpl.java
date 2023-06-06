package com.crud_parcial3.app.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.crud_parcial3.app.Entity.Residentes;
import com.crud_parcial3.app.Repository.residentesRepository;

@Service
public class ResidentesServiceImpl implements IResidentesService{

	@Autowired
	private residentesRepository residentesrepository;

	@Override
	@Transactional(readOnly = true)
	public List<Residentes> findAll() {
		// TODO Auto-generated method stub
		return (List<Residentes>) residentesrepository.findAll();
	}

	@Override
	@Transactional
	public void save(Residentes residentes) {
		// TODO Auto-generated method stub
		residentesrepository.save(residentes);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		residentesrepository.deleteById(id);
	}

	@Override
	public Residentes findOne(Long id) {
		// TODO Auto-generated method stub
		return residentesrepository.findById(id).orElse(null);
	}

}
