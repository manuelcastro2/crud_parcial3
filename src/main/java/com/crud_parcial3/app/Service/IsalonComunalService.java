package com.crud_parcial3.app.Service;

import java.util.List;
import com.crud_parcial3.app.Entity.salonComunal;


public interface IsalonComunalService {
	
	public List<salonComunal> findAll();

	public void save(salonComunal saloncomunal);

	public void delete(Long id);

	public salonComunal findOne(Long id);

}
