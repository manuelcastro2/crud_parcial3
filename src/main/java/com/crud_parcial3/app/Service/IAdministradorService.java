package com.crud_parcial3.app.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.crud_parcial3.app.Entity.Administrador;

@Service
public interface IAdministradorService {

	public List<Administrador> findAll();

	public void save(Administrador administrador);

	public void delete(Long id);

	public Administrador findOne(Long id);

}
