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

import com.lp2_parcial02.entity.Facultad;
import com.lp2_parcial02.service.FacultadService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/facultad")
@CrossOrigin(origins = "http://localhost:4200")
public class FacultadController {

    @Autowired
    private FacultadService facultadService;

    @GetMapping
    public ResponseEntity<List<Facultad>> readAll() {
        try {
            List<Facultad> facultads = facultadService.getAllFacultads();
            if (facultads.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(facultads, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Facultad> crear(@Valid @RequestBody Facultad facultad) {
        try {
            Facultad newFacultad = facultadService.saveFacultad(facultad);
            return new ResponseEntity<>(newFacultad, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Facultad> getFacultadById(@PathVariable("id") Long id) {
        try {
            Optional<Facultad> facultad = Optional.ofNullable(facultadService.getFacultadById(id));
            if (facultad.isPresent()) {
                return new ResponseEntity<>(facultad.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delFacultad(@PathVariable("id") Long id) {
        try {
            facultadService.deleteFacultad(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFacultad(@PathVariable("id") Long id, @Valid @RequestBody Facultad facultad) {
        Optional<Facultad> facultadData = Optional.ofNullable(facultadService.getFacultadById(id));
        if (facultadData.isPresent()) {
            Facultad updatedFacultad = facultadService.updateFacultad(facultad);
            return new ResponseEntity<>(updatedFacultad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
