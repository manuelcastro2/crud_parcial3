package com.crud_parcial3.app.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.crud_parcial3.app.Entity.Eventos;

@Service
public interface IEventosService {
	
	public List<Eventos> findAll();

	public void save(Eventos eventos);

	public void delete(Long id);

	public Eventos findOne(Long id);

}
