package com.crud_parcial3.app.Entity;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name="eventos")
public class Eventos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@NotEmpty
	private String nombreEvento;
	
	@NotEmpty
	private String FechaEvento;
	
	@NotEmpty
	private String Duracion;
	
	@NotEmpty
	private String Valor;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNombreEvento() {
		return nombreEvento;
	}

	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}

	public String getFechaEvento() {
		return FechaEvento;
	}

	public void setFechaEvento(String fechaEvento) {
		FechaEvento = fechaEvento;
	}

	public String getDuracion() {
		return Duracion;
	}

	public void setDuracion(String duracion) {
		Duracion = duracion;
	}

	public String getValor() {
		return Valor;
	}

	public void setValor(String valor) {
		Valor = valor;
	}
	
	

}
