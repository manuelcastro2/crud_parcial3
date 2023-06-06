package com.crud_parcial3.app.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.crud_parcial3.app.Entity.Noticias;
import com.crud_parcial3.app.Repository.noticiasRepository;

@Service
public class NoticiasServiceImpl implements INoticiasService{

	@Autowired
	private noticiasRepository noticiasrepository;

	@Override
	@Transactional(readOnly = true)
	public List<Noticias> findAll() {
		// TODO Auto-generated method stub
		return (List<Noticias>) noticiasrepository.findAll();
	}

	@Override
	@Transactional
	public void save(Noticias noticias) {
		// TODO Auto-generated method stub
		noticiasrepository.save(noticias);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		noticiasrepository.deleteById(id);
	}

	@Override
	public Noticias findOne(Long id) {
		// TODO Auto-generated method stub
		return noticiasrepository.findById(id).orElse(null);
	}

}
