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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    @RequestMapping(value = {"/listarResidentesExcel"}, method = RequestMethod.GET)
	public String listarExcel(Model model) {
		model.addAttribute("residentes", residentesservice.findAll());
		return "listarResidentesExcel";
	}
   
    @PostMapping("/indexResidentes")
	public String indexResidentes() {
		return "indexResidentes";
	}
    
    @PostMapping("/inicioResidentes")
    public String validarinicioResidentes(@RequestParam("cedula") String cedula, @RequestParam("clave") String clave, Model model) {
        
        String url = "jdbc:mysql://localhost:3306/crud_corte3";
        String username = "root";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            String query = "SELECT * FROM residentes WHERE cedula = ? AND clave = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, cedula);
            statement.setString(2, clave);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return "/indexResidentes";
            } else {
                model.addAttribute("error", "Los datos ingresados son incorrectos");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            model.addAttribute("error", "Error de conexión a la base de datos");
            
        }

        return "inicioResidentes";
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
