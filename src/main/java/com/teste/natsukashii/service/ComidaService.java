package com.teste.natsukashii.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.natsukashii.entities.Comida;
import com.teste.natsukashii.repository.ComidaRepository;


@Service
public class ComidaService {
	
	@Autowired
	private ComidaRepository comidaRepository;

    public ComidaService(ComidaRepository comidaRepository) {
        this.comidaRepository = comidaRepository;
    }

    public List<Comida> getAllComida() {
        return comidaRepository.findAll();
    }

    public Comida getComidaById(Long id) {
        Optional<Comida> existingComida = comidaRepository.findById(id);
        return existingComida.orElse(null);
    }

    public Comida createComida(Comida comida) {
        return comidaRepository.save(comida);
    }

    public Comida updateComida(Long id, Comida updatedComida) {
        Optional<Comida> existingComida = comidaRepository.findById(id);
        if (existingComida.isPresent()) {
            updatedComida.setId(id);
            return comidaRepository.save(updatedComida);
        }
        return null;
    }

    public boolean deleteComida(Long id) {
        Optional<Comida> existingComida = comidaRepository.findById(id);
        if (existingComida.isPresent()) {
            comidaRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
