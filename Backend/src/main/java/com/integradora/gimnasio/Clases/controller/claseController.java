package com.integradora.gimnasio.Clases.controller;

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

import com.integradora.gimnasio.Clases.dto.ClaseDto;
import com.integradora.gimnasio.Clases.entity.Clase;
import com.integradora.gimnasio.Clases.service.claseService;
import com.integradora.gimnasio.Clientes.service.clienteService;
import com.integradora.gimnasio.dto.Mensaje;
import com.integradora.gimnasio.exceptions.AttributeException;
import com.integradora.gimnasio.exceptions.ResourceNotFoundException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Clase")
@CrossOrigin
public class claseController {
    
    @Autowired
    claseService claseService;

    @Autowired
    clienteService clienteService;
   
    @PreAuthorize("hasAnyRole('ADMIN','MANTENIMIENTO','INSTRUCTOR','RECEPCIONISTA','USER',)")
    @GetMapping
    public ResponseEntity<List<Clase>> getAll(){
        return ResponseEntity.ok(claseService.getAll());
    }
    
    @PreAuthorize("hasAnyRole('ADMIN','MANTENIMIENTO','INSTRUCTOR','RECEPCIONISTA','USER')")
    @GetMapping("/{id}")
    public ResponseEntity<Clase> getOne(@PathVariable("id") int id) throws ResourceNotFoundException{
        return ResponseEntity.ok(claseService.getOne(id));
    }


    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Mensaje> save(@Valid @RequestBody ClaseDto dto) throws AttributeException{
        Clase clase= claseService.save(dto);
        String message=clase.getNombreClase()+ " class saved";
        return ResponseEntity.ok(new Mensaje(HttpStatus.OK, message));
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Mensaje> update(@PathVariable("id") int id ,@Valid @RequestBody ClaseDto dto) throws ResourceNotFoundException,AttributeException{
        Clase clase= claseService.update(id,dto);
        claseService.updateCosto(id, dto.getCosto());
        String message="updated " +clase.getNombreClase()+ " class";
        return ResponseEntity.ok(new Mensaje(HttpStatus.OK, message));
    } 

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Mensaje> delete(@PathVariable("id") int id)throws ResourceNotFoundException{
        Clase clase= claseService.delete(id);
        String message=clase.getNombreClase()+ " class removed";
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