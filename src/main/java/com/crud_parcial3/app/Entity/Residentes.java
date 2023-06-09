package com.crud_parcial3.app.Entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name="residentes")
public class Residentes implements Serializable{
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	private String Nombre;
	
	@Id
	@Column(unique = true)
	private long Cedula;
	
	@NotEmpty
	private String Correo;
	
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

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}

	public String getClave() {
		return Clave;
	}

	public void setClave(String clave) {
		Clave = clave;
	}
	
	

}
