package com.integradora.gimnasio.Clases.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.integradora.gimnasio.Clases.entity.Clase;

// Este método permite buscar y verificar la existencia de instancias de la entidad Clase en la base de datos MongoDB utilizando métodos personalizados.
@Repository
public interface claseRepository extends MongoRepository<Clase,Integer>{
    boolean existsByNombreClase(String nombreClase);
    Optional<Clase> findByNombreClase(String nombreClase);
}

/* 
Autores del Equipo 1:
Daniela Janeth Cruz Breña 
Miguel Ángel Hernández Solís 
*/
