package com.ejercicios.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicios.model.Persona;

public interface IPersonaRepo extends JpaRepository<Persona, Integer>{

}
