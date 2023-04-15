package com.integradora.gimnasio.Clientes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.integradora.gimnasio.Clientes.entity.Cliente;

/* Método que define una interfaz clienteRepository que extiende la clase MongoRepository de Spring Data MongoDB, 
lo que significa que proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la colección cliente en una base de datos MongoDB.
*/

public interface clienteRepository extends MongoRepository<Cliente,Integer>{
    boolean existsByNombreCliente(String nombreCliente);
    boolean existsByEmail(String email);
    boolean existsByNombreClase(String nombreClase);
    List<Cliente> findByNombreClase(String nombreClase);
    Optional<Cliente> findByNombreCliente(String nombreCliente);
    List<Cliente> findAllByNombreClase(String nombreClase);
}

/* 
Autores del Equipo 1
Daniela Janeth Cruz Breña 
Miguel Ángel Hernández Solís 
*/
