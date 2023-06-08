package com.crud_parcial3.app.Controller;

import com.crud_parcial3.app.Entity.Noticias;
import com.crud_parcial3.app.Service.INoticiasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/noticias")
public class NoticiasController {

    @Autowired
    private INoticiasService noticiasService;

    @GetMapping("/")
    public ResponseEntity<List<Noticias>> getAllNoticias() {
        List<Noticias> noticiasList = noticiasService.findAll();
        return new ResponseEntity<>(noticiasList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Noticias> getNoticiaById(@PathVariable Long id) {
        Noticias noticia = noticiasService.findOne(id);
        if (noticia != null) {
            return new ResponseEntity<>(noticia, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Noticias> createNoticia(@RequestBody Noticias noticia) {
        noticiasService.save(noticia);
        return new ResponseEntity<>(noticia, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Noticias> updateNoticia(@PathVariable Long id, @RequestBody Noticias noticiaDetails) {
        Noticias noticia = noticiasService.findOne(id);
        if (noticia != null) {
            noticia.setNoticia(noticiaDetails.getNoticia());
            noticia.setFechaNoticia(noticiaDetails.getFechaNoticia());
            noticiasService.save(noticia);
            return new ResponseEntity<>(noticia, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNoticia(@PathVariable Long id) {
        Noticias noticia = noticiasService.findOne(id);
        if (noticia != null) {
            noticiasService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
