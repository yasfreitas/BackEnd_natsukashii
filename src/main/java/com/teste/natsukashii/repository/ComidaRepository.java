package com.teste.natsukashii.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.natsukashii.entities.Comida;

@Repository
public interface ComidaRepository extends JpaRepository<Comida, Long>{

}
