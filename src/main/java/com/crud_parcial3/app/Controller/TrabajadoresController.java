package com.crud_parcial3.app.Controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.crud_parcial3.app.Entity.Trabajadores;
import com.crud_parcial3.app.Service.ITrabajadoresService;

@RestController
@RequestMapping("/trabajadores")
public class TrabajadoresController {

    @Autowired
    private ITrabajadoresService trabajadoresService;

    @GetMapping
    public ResponseEntity<List<Trabajadores>> getAllTrabajadores() {
        List<Trabajadores> trabajadores = trabajadoresService.findAll();
        return new ResponseEntity<>(trabajadores, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createTrabajador(@Valid @RequestBody Trabajadores trabajador) {
        trabajadoresService.save(trabajador);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trabajadores> getTrabajadorById(@PathVariable("id") Long id) {
        Trabajadores trabajador = trabajadoresService.findOne(id);
        if (trabajador != null) {
            return new ResponseEntity<>(trabajador, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTrabajador(@PathVariable("id") Long id, @Valid @RequestBody Trabajadores trabajador) {
        Trabajadores existingTrabajador = trabajadoresService.findOne(id);
        if (existingTrabajador != null) {
        	existingTrabajador.setCedula(trabajador.getCedula());
            existingTrabajador.setCargo(trabajador.getCargo());
            existingTrabajador.setEmpresa(trabajador.getEmpresa());
            existingTrabajador.setClave(trabajador.getClave());
            trabajadoresService.save(existingTrabajador);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrabajador(@PathVariable("id") Long id) {
        Trabajadores existingTrabajador = trabajadoresService.findOne(id);
        if (existingTrabajador != null) {
            trabajadoresService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
