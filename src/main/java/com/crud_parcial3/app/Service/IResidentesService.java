package com.crud_parcial3.app.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.crud_parcial3.app.Entity.Residentes;

@Service
public interface IResidentesService {
	
	public List<Residentes> findAll();

	public void save(Residentes residentes);

	public void delete(Long id);

	public Residentes findOne(Long id);

}
