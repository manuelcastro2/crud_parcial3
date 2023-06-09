package com.crud_parcial3.app.Entity;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name="saloncomunal")
public class salonComunal {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	private Long Id;
	
	@NotEmpty
	private String Reservacion;
	
	@NotEmpty
	private String fechaReservacion;
	
	@NotEmpty
	private String horaReservacion;
	
	@NotEmpty
	private String idResidente;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getReservacion() {
		return Reservacion;
	}

	public void setReservacion(String reservacion) {
		Reservacion = reservacion;
	}

	public String getFechaReservacion() {
		return fechaReservacion;
	}

	public void setFechaReservacion(String fechaReservacion) {
		this.fechaReservacion = fechaReservacion;
	}

	public String getHoraReservacion() {
		return horaReservacion;
	}

	public void setHoraReservacion(String horaReservacion) {
		this.horaReservacion = horaReservacion;
	}

	public String getIdResidente() {
		return idResidente;
	}

	public void setIdResidente(String idResidente) {
		this.idResidente = idResidente;
	}
	
	

}
