package com.crud_parcial3.app.Controller;

import com.crud_parcial3.app.Entity.Residentes;
import com.crud_parcial3.app.Service.IResidentesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.Map;

@Controller
@SessionAttributes("residentes")
public class ResidentesController {

    @Autowired
    private IResidentesService residentesservice;
    
    @GetMapping("/inicioresidentes")
	public String inicioResidentes() {
		return "inicioResidentes";
	}
    
    @PostMapping("/indexResidentes")
    public String indexResidentes() {
		return "indexResidentes";
	}

    @GetMapping("/SaveResidentes")
	public String CallFormResidentes(Map<String, Object> model) {
		Residentes residentes = new Residentes();
		model.put("residentes", residentes);
		return "SaveResidentes";
	}

	@PostMapping("/SaveResidentes")
	public String SaveResidente(@Valid Residentes residentes, BindingResult result, Model model,
			SessionStatus status) {
		if (result.hasErrors()) {
			return "SaveResidentes";
		}

		residentesservice.save(residentes);
		status.setComplete();
		return "redirect:/listarResidentes";
	}

	@GetMapping("/listarResidentes")
	public String mostrarlistarAsociacion(Model model) {
		model.addAttribute("residentes", residentesservice.findAll());
		return "listarResidentes";
	}

	@GetMapping("/eliminarResidentes/{cedula}")
	public String borrarAsociacion(@PathVariable("cedula") Long cedula) {
		if (cedula > 0) {
			residentesservice.delete(cedula);
		}
		return "redirect:/listarResidentes";
	}

	@GetMapping("/SaveResidentes/{cedula}")
	public String editarResidentes(@PathVariable("cedula") Long cedula, Map<String, Object> model) {
		Residentes residentes = null;
		if (cedula > 0) {
			residentes = residentesservice.findOne(cedula);
		} else {
			return "redirect:/listarResidentes";
		}
		model.put("residentes", residentes);
		return "SaveResidentes";
	}
}
