package com.crud_parcial3.app.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.crud_parcial3.app.Entity.salonComunal;
import com.crud_parcial3.app.Repository.saloncomunalRepository;

@Service
public class salonComunalServiceImpl implements IsalonComunalService{

	@Autowired
	private saloncomunalRepository saloncomunalrepository;

	@Override
	@Transactional(readOnly = true)
	public List<salonComunal> findAll() {
		// TODO Auto-generated method stub
		return (List<salonComunal>) saloncomunalrepository.findAll();
	}

	@Override
	@Transactional
	public void save(salonComunal saloncomunal) {
		// TODO Auto-generated method stub
		saloncomunalrepository.save(saloncomunal);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		saloncomunalrepository.deleteById(id);
	}

	@Override
	public salonComunal findOne(Long id) {
		// TODO Auto-generated method stub
		return saloncomunalrepository.findById(id).orElse(null);
	}

}
