package com.crud_parcial3.app.Controller;

import com.crud_parcial3.app.Entity.Administrador;
import com.crud_parcial3.app.Service.IAdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@Controller
@SessionAttributes("administradores")
public class AdministradorController {

    @Autowired
    private IAdministradorService administradorservice;

	@GetMapping("/inicioadmin")
	public String inicioAdministrador() {
		return "inicioadmin";
	}
	
	@PostMapping("/indexAdministrador")
	public String indexAdministrador() {
		return "indexAdministrador";
	}
	
    @PostMapping("/inicioadmin")
    public String validarInicioadmin(@RequestParam("cedula") String cedula, @RequestParam("clave") String clave, Model model) {
        
        String url = "jdbc:mysql://localhost:3306/crud_corte3";
        String username = "root";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            String query = "SELECT * FROM administrador WHERE cedula = ? AND clave = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, cedula);
            statement.setString(2, clave);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return "/indexAdministrador";
            } else {
                model.addAttribute("error", "Los datos ingresados son incorrectos");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            model.addAttribute("error", "Error de conexión a la base de datos");
            
        }

        return "inicioadmin";
    }
	
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
