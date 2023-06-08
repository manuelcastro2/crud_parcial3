package com.crud_parcial3.app.Controller;

import com.crud_parcial3.app.Entity.Administrador;
import com.crud_parcial3.app.Service.IAdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import java.util.Map;

@Controller
@SessionAttributes("administradores")
public class AdministradorController {

    @Autowired
    private IAdministradorService administradorservice;

    @GetMapping("/SaveAdministrador")
    public String CallFormAdministrador(Map<String, Object> model) {
        Administrador administrador = new Administrador();
        model.put("administrador",administrador);
		return "SaveAdministrador";
    }

    @PostMapping("/SaveAdministrador")
	public String SaveAdministradores( Administrador administrador, BindingResult result, Model model,
			SessionStatus status) {
		if (result.hasErrors()) {
			return "SaveAdministrador";
		}

		administradorservice.save(administrador);
		status.setComplete();
		return "redirect:/listarAdministrador";
	}
    
    @GetMapping("/listarAdministrador")
	public String mostrarlistarAsociacion(Model model) {
		model.addAttribute("administrador", administradorservice.findAll());
		return "listarAdministrador";
	}
    
    @GetMapping("/eliminarAdministrador/{cedula}")
	public String borrarAsociacion(@PathVariable("cedula") Long cedula) {
		if (cedula > 0) {
			administradorservice.delete(cedula);
		}
		return "redirect:/listarAdministrador";
	}
    
    
    
}
