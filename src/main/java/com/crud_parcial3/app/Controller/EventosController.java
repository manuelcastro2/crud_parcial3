package com.crud_parcial3.app.Controller;

import com.crud_parcial3.app.Entity.Eventos;
import com.crud_parcial3.app.Service.IEventosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventosController {

    @Autowired
    private IEventosService eventosService;

    @GetMapping("/")
    public ResponseEntity<List<Eventos>> getAllEventos() {
        List<Eventos> eventosList = eventosService.findAll();
        return new ResponseEntity<>(eventosList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Eventos> getEventoById(@PathVariable Long id) {
        Eventos evento = eventosService.findOne(id);
        if (evento != null) {
            return new ResponseEntity<>(evento, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Eventos> createEvento(@RequestBody Eventos evento) {
        eventosService.save(evento);
        return new ResponseEntity<>(evento, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Eventos> updateEvento(@PathVariable Long id, @RequestBody Eventos eventoDetails) {
        Eventos evento = eventosService.findOne(id);
        if (evento != null) {
            evento.setNombreEvento(eventoDetails.getNombreEvento());
            evento.setFechaEvento(eventoDetails.getFechaEvento());
            evento.setDuracion(eventoDetails.getDuracion());
            evento.setValor(eventoDetails.getValor());
            eventosService.save(evento);
            return new ResponseEntity<>(evento, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvento(@PathVariable Long id) {
        Eventos evento = eventosService.findOne(id);
        if (evento != null) {
            eventosService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
