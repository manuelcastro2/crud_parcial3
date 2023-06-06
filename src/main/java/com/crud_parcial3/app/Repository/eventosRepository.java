package com.crud_parcial3.app.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crud_parcial3.app.Entity.Eventos;

@Repository
public interface eventosRepository extends CrudRepository<Eventos, Long>{

}
