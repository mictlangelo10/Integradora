package com.integradora.gimnasio.Clientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.integradora.gimnasio.Clientes.dto.ClienteDto;
import com.integradora.gimnasio.Clientes.entity.Cliente;
import com.integradora.gimnasio.Clientes.service.clienteService;
import com.integradora.gimnasio.dto.Mensaje;
import com.integradora.gimnasio.exceptions.AttributeException;
import com.integradora.gimnasio.exceptions.ResourceNotFoundException;

import jakarta.validation.Valid;

/*
Requisitos necesarios para indicar 
que la clase es un controlador de Spring MVC que maneja solicitudes HTTP que comienzan con "/Cliente" y permite solicitudes de recursos 
desde otros dominios diferentes al dominio de origen del recurso.
*/


@RestController
@RequestMapping("/Cliente")
@CrossOrigin
public class clienteController {
    
    @Autowired
    clienteService clienteService;

    /* 
    Método que se utiliza para se utiliza para devolver la lista completa de clientes y se asegura de que
    solo los usuarios autorizados puedan acceder a la información utilizando la anotación @PreAuthorize.
    */
    @PreAuthorize("hasAnyRole('ADMIN','MANTENIMIENTO','INSTRUCTOR','RECEPCIONISTA','USER',)")
    @GetMapping
    public ResponseEntity<List<Cliente>> getAll(){
        return ResponseEntity.ok(clienteService.getAll());
    }

    /*
    Método que se utiliza para obtener la lista de clientes que están registrados en una clase con un nombre específico 
    y se asegura de que solo los usuarios autorizados puedan acceder a la información utilizando la anotación @PreAuthorize.
    */
    @PreAuthorize("hasAnyRole('ADMIN','MANTENIMIENTO','INSTRUCTOR','RECEPCIONISTA','USER',)")
    @GetMapping("/NombreClase/{nombreClase}")
    public ResponseEntity<List<Cliente>> getAllByNombreClase(@PathVariable("nombreClase") String nombreClase){
        return ResponseEntity.ok(clienteService.getAllByNombreClase(nombreClase));
    }
    
    /*
    Método que se utiliza para recuperar un cliente específico de la base de datos utilizando el identificador único proporcionado
    y se asegura de que solo los usuarios autorizados puedan acceder a la información utilizando la anotación @PreAuthorize.
    */
    @PreAuthorize("hasAnyRole('ADMIN','MANTENIMIENTO','INSTRUCTOR','RECEPCIONISTA','USER')")
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getOne(@PathVariable("id") int id) throws ResourceNotFoundException{
        return ResponseEntity.ok(clienteService.getOne(id));
    }

    /*
    Método que  utiliza la anotación @PreAuthorize para asegurarse de que solo los usuarios con el rol "ADMIN" puedan 
    guardar un nuevo objeto Cliente en la base de datos. El método recibe un objeto ClienteDto a través del cuerpo de la petición HTTP y 
    lo valida con la anotación @Valid. Después de validar el objeto, se utiliza el servicio clienteService para guardar el objeto en la base de datos y 
    se devuelve una respuesta ResponseEntity con un mensaje que indica si la operación se completó con éxito o no. 
    */
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Mensaje> save(@Valid @RequestBody ClienteDto dto) throws AttributeException,ResourceNotFoundException{
        Cliente cliente= clienteService.save(dto);
        String message="Client " +cliente.getNombreCliente()+ " saved";
        return ResponseEntity.ok(new Mensaje(HttpStatus.OK, message));
    }

    /*
    Método que se utiliza para actualizar un objeto Cliente en la base de datos. 
    Sólo los usuarios con el rol "ADMIN" pueden acceder a este método. Recibe el identificador del objeto Cliente a actualizar a través del parámetro id 
    en la ruta URL de la petición HTTP, y los nuevos datos del objeto Cliente a través del cuerpo de la petición HTTP en formato ClienteDto.
    */
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Mensaje> update(@PathVariable("id") int id ,@Valid @RequestBody ClienteDto dto) throws ResourceNotFoundException,AttributeException{
        Cliente cliente= clienteService.update(id,dto);
        String message="Client " +cliente.getNombreCliente()+ " updated";
        return ResponseEntity.ok(new Mensaje(HttpStatus.OK, message));
    } 
    
    /*
    Método que elimina un objeto Cliente de la base de datos mediante la invocación del método delete() del servicio de clientes. 
    Luego, se devuelve un objeto ResponseEntity con un mensaje indicando que el cliente se eliminó con éxito.
    */
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Mensaje> delete(@PathVariable("id") int id)throws ResourceNotFoundException{
        Cliente cliente= clienteService.delete(id);
        String message="Client " +cliente.getNombreCliente()+ " removed";
        return ResponseEntity.ok(new Mensaje(HttpStatus.OK, message));
    }
}

/* 
Autores del Equipo 1
Daniela Janeth Cruz Breña 
Miguel Ángel Hernández Solís 
*/
