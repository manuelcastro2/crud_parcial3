package com.crud_parcial3.app.Controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.crud_parcial3.app.Entity.salonComunal;
import com.crud_parcial3.app.Service.IsalonComunalService;

@RestController
@RequestMapping("/saloncomunal")
public class salonComunalController {

    @Autowired
    private IsalonComunalService salonComunalService;

    @GetMapping
    public ResponseEntity<List<salonComunal>> getAllSalonComunals() {
        List<salonComunal> salonComunals = salonComunalService.findAll();
        return new ResponseEntity<>(salonComunals, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createSalonComunal(@Valid @RequestBody salonComunal saloncomunal) {
        salonComunalService.save(saloncomunal);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<salonComunal> getSalonComunalById(@PathVariable("id") Long id) {
        salonComunal saloncomunal = salonComunalService.findOne(id);
        if (saloncomunal != null) {
            return new ResponseEntity<>(saloncomunal, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateReservacion(@PathVariable("id") Long id, @Valid @RequestBody salonComunal salonComunal) {
        salonComunal existingSalonComunal = salonComunalService.findOne(id);
        if (existingSalonComunal != null) {
            existingSalonComunal.setReservacion(salonComunal.getReservacion());
            existingSalonComunal.setFechaReservacion(salonComunal.getFechaReservacion());
            existingSalonComunal.setHoraReservacion(salonComunal.getHoraReservacion());
            salonComunalService.save(existingSalonComunal);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalonComunal(@PathVariable("id") Long id) {
        salonComunal existingSalonComunal = salonComunalService.findOne(id);
        if (existingSalonComunal != null) {
            salonComunalService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
