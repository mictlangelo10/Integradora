package com.integradora.gimnasio.Clientes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.integradora.gimnasio.Clientes.entity.Cliente;

public interface clienteRepository extends MongoRepository<Cliente,Integer>{
    boolean existsByNombreCliente(String nombreCliente);
    boolean existsByEmail(String email);
    boolean existsByNombreClase(String nombreClase);
    List<Cliente> findByNombreClase(String nombreClase);
    Optional<Cliente> findByNombreCliente(String nombreCliente);
    List<Cliente> findAllByNombreClase(String nombreClase);
}

/* 
Equipo 1
Daniela Janeth Cruz Breña 
Miguel Ángel Hernández Solís 
Miguel Ángel Jaime García 
Filiberto Navarro Grifaldo 
*/