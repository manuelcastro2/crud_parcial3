package com.crud_parcial3.app.Controller;

import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import com.crud_parcial3.app.Entity.Trabajadores;
import com.crud_parcial3.app.Service.ITrabajadoresService;


@Controller
@SessionAttributes("trabajadores")
public class TrabajadoresController {

    @Autowired
    private ITrabajadoresService trabajadoresservice;

    @GetMapping("/SaveTrabajadores")
	public String CallFormTrabajadores(Map<String, Object> model) {
		Trabajadores trabajadores = new Trabajadores();
		model.put("trabajadores", trabajadores);
		return "SaveTrabajadores";
	}

	@PostMapping("/SaveTrabajadores")
	public String SaveTrabajadores(@Valid Trabajadores trabajadores, BindingResult result, Model model,
			SessionStatus status) {
		if (result.hasErrors()) {
			return "SaveTrabajadores";
		}

		trabajadoresservice.save(trabajadores);
		status.setComplete();
		return "redirect:/listarTrabajadores";
	}

	@GetMapping("/listarTrabajadores")
	public String mostrarlistaTrabajadores(Model model) {
		model.addAttribute("trabajadores", trabajadoresservice.findAll());
		return "listarTrabajadores";
	}

	@GetMapping("/eliminarTrabajadores/{cedula}")
	public String borrarTrabajadores(@PathVariable("cedula") Long cedula) {
		if (cedula > 0) {
			trabajadoresservice.delete(cedula);
		}
		return "redirect:/listarTrabajadores";
	}

	@GetMapping("SaveTrabajadores/{cedula}")
	public String editarTrabajadores(@PathVariable("cedula") Long cedula, Map<String, Object> model) {
		Trabajadores trabajadores = null;
		if (cedula > 0) {
			trabajadores = trabajadoresservice.findOne(cedula);
		} else {
			return "redirect:/listarTrabajadores";
		}
		model.put("trabajadores", trabajadores);
		return "SaveTrabajadores";
	}
}
