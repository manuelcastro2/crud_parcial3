package com.crud_parcial3.app.Entity;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name="administrador")
public class Administrador {
	@NotEmpty
	private String Nombre;
	
	@Id
	@Column(unique = true)
	private Long Cedula;
	
	@NotEmpty
	private String Clave;
	

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public Long getCedula() {
		return Cedula;
	}

	public void setCedula(Long cedula) {
		Cedula = cedula;
	}

	public String getClave() {
		return Clave;
	}

	public void setClave(String clave) {
		Clave = clave;
	}
	
	

}
