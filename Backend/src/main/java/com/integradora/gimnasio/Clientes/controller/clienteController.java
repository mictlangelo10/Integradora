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

@RestController
@RequestMapping("/Cliente")
@CrossOrigin
public class clienteController {
    
    @Autowired
    clienteService clienteService;

   
    @PreAuthorize("hasAnyRole('ADMIN','MANTENIMIENTO','INSTRUCTOR','RECEPCIONISTA','USER',)")
    @GetMapping
    public ResponseEntity<List<Cliente>> getAll(){
        return ResponseEntity.ok(clienteService.getAll());
    }

    @PreAuthorize("hasAnyRole('ADMIN','MANTENIMIENTO','INSTRUCTOR','RECEPCIONISTA','USER',)")
    @GetMapping("/NombreClase/{nombreClase}")
    public ResponseEntity<List<Cliente>> getAllByNombreClase(@PathVariable("nombreClase") String nombreClase){
        return ResponseEntity.ok(clienteService.getAllByNombreClase(nombreClase));
    }
    
    @PreAuthorize("hasAnyRole('ADMIN','MANTENIMIENTO','INSTRUCTOR','RECEPCIONISTA','USER')")
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getOne(@PathVariable("id") int id) throws ResourceNotFoundException{
        return ResponseEntity.ok(clienteService.getOne(id));
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Mensaje> save(@Valid @RequestBody ClienteDto dto) throws AttributeException,ResourceNotFoundException{
        Cliente cliente= clienteService.save(dto);
        String message="Client " +cliente.getNombreCliente()+ " saved";
        return ResponseEntity.ok(new Mensaje(HttpStatus.OK, message));
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Mensaje> update(@PathVariable("id") int id ,@Valid @RequestBody ClienteDto dto) throws ResourceNotFoundException,AttributeException{
        Cliente cliente= clienteService.update(id,dto);
        String message="Client " +cliente.getNombreCliente()+ " updated";
        return ResponseEntity.ok(new Mensaje(HttpStatus.OK, message));
    } 

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Mensaje> delete(@PathVariable("id") int id)throws ResourceNotFoundException{
        Cliente cliente= clienteService.delete(id);
        String message="Client " +cliente.getNombreCliente()+ " removed";
        return ResponseEntity.ok(new Mensaje(HttpStatus.OK, message));
    }
}

/* 
Equipo 1
Daniela Janeth Cruz Breña 
Miguel Ángel Hernández Solís 
Miguel Ángel Jaime García 
Filiberto Navarro Grifaldo 
*/