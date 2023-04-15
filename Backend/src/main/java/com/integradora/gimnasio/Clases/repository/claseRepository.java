package com.integradora.gimnasio.Clases.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.integradora.gimnasio.Clases.entity.Clase;

@Repository
public interface claseRepository extends MongoRepository<Clase,Integer>{
    boolean existsByNombreClase(String nombreClase);
    Optional<Clase> findByNombreClase(String nombreClase);
}

/* 
Equipo 1
Daniela Janeth Cruz Breña 
Miguel Ángel Hernández Solís 
Miguel Ángel Jaime García 
Filiberto Navarro Grifaldo 
*/