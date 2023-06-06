package com.crud_parcial3.app.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.crud_parcial3.app.Entity.Noticias;

@Service
public interface INoticiasService {
	
	public List<Noticias> findAll();

	public void save(Noticias noticias);

	public void delete(Long id);

	public Noticias findOne(Long id);

}
