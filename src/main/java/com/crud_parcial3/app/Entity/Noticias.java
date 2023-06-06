package com.crud_parcial3.app.Entity;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name="noticias")
public class Noticias {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@NotEmpty
	private String Noticia;
	
	@NotEmpty
	private String FechaNoticia;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNoticia() {
		return Noticia;
	}

	public void setNoticia(String noticia) {
		Noticia = noticia;
	}

	public String getFechaNoticia() {
		return FechaNoticia;
	}

	public void setFechaNoticia(String fechaNoticia) {
		FechaNoticia = fechaNoticia;
	}
	
	
	

}
