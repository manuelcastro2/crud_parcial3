package com.crud_parcial3.app.Controller;

import java.util.Map;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import com.crud_parcial3.app.Entity.salonComunal;
import com.crud_parcial3.app.Service.IsalonComunalService;

@Controller
@SessionAttributes("saloncomunal")
public class salonComunalController {

    @Autowired
    private IsalonComunalService saloncomunalservice;


	@GetMapping("/SaveSalonComunal")
	public String CallFormSalonComunal(Map<String, Object> model) {
		salonComunal saloncomunal = new salonComunal();
		model.put("saloncomunal", saloncomunal);
		return "SaveSalonComunal";
	}

	@PostMapping("/SaveSalonComunal")
	public String SaveSalonComunal(@Valid salonComunal saloncomunal, BindingResult result, Model model,
			SessionStatus status) {
		if (result.hasErrors()) {
			return "SaveSalonComunal";
		}

		saloncomunalservice.save(saloncomunal);
		status.setComplete();
		return "redirect:/listarsalonComunal";
	}

	@GetMapping("/listarsalonComunal")
	public String mostrarlistarAsociacion(Model model) {
		model.addAttribute("saloncomunal", saloncomunalservice.findAll());
		return "listarsalonComunal";
	}

	@GetMapping("/eliminarSalonComunal/{id}")
	public String borrarAsociacion(@PathVariable("id") Long id) {
		if (id > 0) {
			saloncomunalservice.delete(id);
		}
		return "redirect:/listarsalonComunal";
	}

	@GetMapping("SaveSalonComunal/{id}")
	public String editarSalonComunal(@PathVariable("id") Long id, Map<String, Object> model) {
		salonComunal saloncomunal = null;
		if (id > 0) {
			saloncomunal = saloncomunalservice.findOne(id);
		} else {
			return "redirect:/listarsalonComunal";
		}
		model.put("saloncomunal", saloncomunal);
		return "SaveSalonComunal";
	}
}
