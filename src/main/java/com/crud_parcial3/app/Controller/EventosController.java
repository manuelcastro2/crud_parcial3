package com.crud_parcial3.app.Controller;

import com.crud_parcial3.app.Entity.Eventos;
import com.crud_parcial3.app.Service.IEventosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import java.util.Map;

@Controller
@SessionAttributes("eventos")
public class EventosController {

    @Autowired
    private IEventosService eventosservice;

    @GetMapping("/SaveEventos")
	public String CallformEEvento(Map<String, Object> model) {
		Eventos eventos = new Eventos();
		model.put("eventos", eventos);
		return "SaveEventos";
	}

	@PostMapping("/SaveEventos")
	public String SaveEventos(Eventos eventos, BindingResult result, Model model,
			SessionStatus status) {
		if (result.hasErrors()) {
			return "SaveEventos";
		}

		eventosservice.save(eventos);
		status.setComplete();
		return "redirect:/listarEventos";
	}

	@GetMapping("/listarEventos")
	public String mostrarlistarAsociacion(Model model) {
		model.addAttribute("eventos", eventosservice.findAll());
		return "listarEventos";
	}

	@GetMapping("/eliminarEventos/{id}")
	public String borrarAsociacion(@PathVariable("id") Long id) {
		if (id > 0) {
			eventosservice.delete(id);
		}
		return "redirect:/listarEventos";
	}

	
}
