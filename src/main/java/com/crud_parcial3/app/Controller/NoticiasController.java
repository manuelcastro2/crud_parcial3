package com.crud_parcial3.app.Controller;

import com.crud_parcial3.app.Entity.Noticias;
import com.crud_parcial3.app.Service.INoticiasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Map;

@Controller
@SessionAttributes("noticias")
public class NoticiasController {

    @Autowired
    private INoticiasService noticiasservice;

    @GetMapping("/SaveNoticias")
   	public String CallformNoticias(Map<String, Object> model) {
   		Noticias noticias = new Noticias();
   		model.put("noticias", noticias);
   		return "SaveNoticias";
   	}

   	@PostMapping("/SaveNoticias")
   	public String SaveNoticias(Noticias noticias, BindingResult result, Model model,
   			SessionStatus status) {
   		if (result.hasErrors()) {
   			return "SaveNoticias";
   		}

   		noticiasservice.save(noticias);
   		status.setComplete();
   		return "redirect:/listarNoticias";
   	}

   	@GetMapping("/listarNoticias")
   	public String mostrarlistarAsociacion(Model model) {
   		model.addAttribute("noticias", noticiasservice.findAll());
   		return "listarNoticias";
   	}

   	@GetMapping("/eliminarNoticias/{id}")
   	public String borrarNoticias(@PathVariable("id") Long id) {
   		if (id > 0) {
   			noticiasservice.delete(id);
   		}
   		return "redirect:/listarNoticias";
   	}
}
