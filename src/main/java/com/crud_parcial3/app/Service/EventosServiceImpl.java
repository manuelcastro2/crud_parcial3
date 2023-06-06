package com.crud_parcial3.app.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.crud_parcial3.app.Entity.Eventos;
import com.crud_parcial3.app.Repository.eventosRepository;

@Service
public class EventosServiceImpl implements IEventosService{
	
	@Autowired
	private eventosRepository eventosrepository;

	@Override
	@Transactional(readOnly = true)
	public List<Eventos> findAll() {
		// TODO Auto-generated method stub
		return (List<Eventos>) eventosrepository.findAll();
	}

	@Override
	@Transactional
	public void save(Eventos eventos) {
		// TODO Auto-generated method stub
		eventosrepository.save(eventos);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		eventosrepository.deleteById(id);
	}

	@Override
	public Eventos findOne(Long id) {
		// TODO Auto-generated method stub
		return eventosrepository.findById(id).orElse(null);
	}

}
