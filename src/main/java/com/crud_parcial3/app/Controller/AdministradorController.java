package com.crud_parcial3.app.Controller;

import com.crud_parcial3.app.Entity.Administrador;
import com.crud_parcial3.app.Service.IAdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administradores")
public class AdministradorController {

    @Autowired
    private IAdministradorService administradorService;

    @GetMapping
    public ResponseEntity<List<Administrador>> getAllAdministradores() {
        List<Administrador> administradores = administradorService.findAll();
        return new ResponseEntity<>(administradores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Administrador> getAdministradorById(@PathVariable Long id) {
        Administrador administrador = administradorService.findOne(id);
        if (administrador != null) {
            return new ResponseEntity<>(administrador, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Administrador> createAdministrador(@RequestBody Administrador administrador) {
        administradorService.save(administrador);
        return new ResponseEntity<>(administrador, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Administrador> updateAdministrador(@PathVariable Long id, @RequestBody Administrador administrador) {
        Administrador currentAdministrador = administradorService.findOne(id);
        if (currentAdministrador != null) {
            currentAdministrador.setNombre(administrador.getNombre());
            currentAdministrador.setCedula(administrador.getCedula());
            currentAdministrador.setClave(administrador.getClave());
            administradorService.save(currentAdministrador);
            return new ResponseEntity<>(currentAdministrador, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdministrador(@PathVariable Long id) {
        Administrador administrador = administradorService.findOne(id);
        if (administrador != null) {
            administradorService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
