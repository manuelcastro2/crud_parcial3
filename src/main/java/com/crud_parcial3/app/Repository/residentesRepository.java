package com.crud_parcial3.app.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crud_parcial3.app.Entity.Residentes;

@Repository
public interface residentesRepository extends CrudRepository<Residentes, Long>{

}
