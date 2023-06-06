package com.crud_parcial3.app.Entity;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name="trabajadores")
public class Trabajadores {
	@NotEmpty
	private String Nombre;
	
	@Id
	@Column(unique = true)
	private String Cedula;
	
	@NotEmpty
	private String Cargo;
	
	@NotEmpty
	private String Empresa;
	
	@NotEmpty
	private String Clave;

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getCedula() {
		return Cedula;
	}

	public void setCedula(String cedula) {
		Cedula = cedula;
	}

	public String getCargo() {
		return Cargo;
	}

	public void setCargo(String cargo) {
		Cargo = cargo;
	}

	public String getEmpresa() {
		return Empresa;
	}

	public void setEmpresa(String empresa) {
		Empresa = empresa;
	}

	public String getClave() {
		return Clave;
	}

	public void setClave(String clave) {
		Clave = clave;
	}

	
	

}
