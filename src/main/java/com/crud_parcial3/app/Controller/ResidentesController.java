package com.crud_parcial3.app.Controller;

import com.crud_parcial3.app.Entity.Residentes;
import com.crud_parcial3.app.Service.IResidentesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/residentes")
public class ResidentesController {

    @Autowired
    private IResidentesService residentesService;

    @GetMapping
    public ResponseEntity<List<Residentes>> getAllResidentes() {
        List<Residentes> residentes = residentesService.findAll();
        return new ResponseEntity<>(residentes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createResidente(@Valid @RequestBody Residentes residente) {
        residentesService.save(residente);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Residentes> getResidenteById(@PathVariable("id") Long id) {
        Residentes residente = residentesService.findOne(id);
        if (residente != null) {
            return new ResponseEntity<>(residente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateResidente(@PathVariable("id") Long id, @Valid @RequestBody Residentes residente) {
        Residentes existingResidente = residentesService.findOne(id);
        if (existingResidente != null) {
            existingResidente.setNombre(residente.getNombre());
            existingResidente.setCedula(residente.getCedula());
            existingResidente.setCorreo(residente.getCorreo());
            existingResidente.setClave(residente.getClave());
            residentesService.save(existingResidente);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResidente(@PathVariable("id") Long id) {
        Residentes residente = residentesService.findOne(id);
        if (residente != null) {
            residentesService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
