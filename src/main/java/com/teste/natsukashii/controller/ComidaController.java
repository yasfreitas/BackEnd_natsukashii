package com.teste.natsukashii.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.teste.natsukashii.entities.Comida;
import com.teste.natsukashii.service.ComidaService;



@RestController
@RequestMapping("/comida")
@CrossOrigin(origins = "*")
public class ComidaController {
	
	@Autowired
    private ComidaService comidaService;

    @GetMapping
    public List<Comida> getAllComida() {
        return comidaService.getAllComida();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comida> getComidaById(@PathVariable Long id) {
        return ResponseEntity.ok(comidaService.getComidaById(id));
    }

    @PostMapping
    public ResponseEntity<Comida> createComida(@RequestBody Comida post) {
        return ResponseEntity.ok(comidaService.createComida(post));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comida> updateComida(@PathVariable Long id, @RequestBody Comida updatedComida) {
        return ResponseEntity.ok(comidaService.updateComida(id, updatedComida));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComida(@PathVariable Long id) {
        comidaService.deleteComida(id);
        return ResponseEntity.noContent().build();
    }

}
