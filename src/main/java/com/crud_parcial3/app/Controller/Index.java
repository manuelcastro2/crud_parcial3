package com.crud_parcial3.app.Controller;

import org.springframework.web.bind.annotation.GetMapping;

public class Index {

	@GetMapping("/")
	public String index() {
		return"/";
	}
	
	@GetMapping("/inicioAdministrador")
	public String inicioAdministrador() {
		return "inicio-sesion-Administrador";
	}
	
	
	
}
