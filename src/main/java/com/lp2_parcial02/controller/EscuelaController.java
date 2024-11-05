package com.lp2_parcial02.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lp2_parcial02.entity.Escuela;
import com.lp2_parcial02.service.EscuelaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/escuela")
@CrossOrigin(origins = "http://localhost:4200")
public class EscuelaController {

    @Autowired
    private EscuelaService escuelaService;

    @GetMapping
    public ResponseEntity<List<Escuela>> readAll() {
        try {
            List<Escuela> escuelas = escuelaService.getAllEscuelas();
            if (escuelas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(escuelas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Escuela> crear(@Valid @RequestBody Escuela escuela) {
        try {
            Escuela newEscuela = escuelaService.saveEscuela(escuela);
            return new ResponseEntity<>(newEscuela, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Escuela> getEscuelaById(@PathVariable("id") Long id) {
        try {
            Optional<Escuela> escuela = Optional.ofNullable(escuelaService.getEscuelaById(id));
            if (escuela.isPresent()) {
                return new ResponseEntity<>(escuela.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delEscuela(@PathVariable("id") Long id) {
        try {
            escuelaService.deleteEscuela(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEscuela(@PathVariable("id") Long id, @Valid @RequestBody Escuela escuela) {
        Optional<Escuela> escuelaData = Optional.ofNullable(escuelaService.getEscuelaById(id));
        if (escuelaData.isPresent()) {
            Escuela updatedEscuela = escuelaService.updateEscuela(escuela);
            return new ResponseEntity<>(updatedEscuela, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
