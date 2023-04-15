package com.integradora.gimnasio.CheckIn.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integradora.gimnasio.CheckIn.dto.CheckInDto;
import com.integradora.gimnasio.CheckIn.entity.CheckIn;
import com.integradora.gimnasio.CheckIn.service.checkInService;
import com.integradora.gimnasio.dto.Mensaje;
import com.integradora.gimnasio.exceptions.AttributeException;
import com.integradora.gimnasio.exceptions.ResourceNotFoundException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/check-in")
@CrossOrigin
public class checkInController {
    
    @Autowired
    checkInService checkInService;

   
    @PreAuthorize("hasAnyRole('ADMIN','MANTENIMIENTO','INSTRUCTOR','RECEPCIONISTA','USER',)")
    @GetMapping
    public ResponseEntity<List<CheckIn>> getAll(){
        return ResponseEntity.ok(checkInService.getAll());
    }
    
    @PreAuthorize("hasAnyRole('ADMIN','MANTENIMIENTO','INSTRUCTOR','RECEPCIONISTA','USER')")
    @GetMapping("/{id}")
    public ResponseEntity<CheckIn> getOne(@PathVariable("id") int id) throws ResourceNotFoundException{
        return ResponseEntity.ok(checkInService.getOne(id));
    }

    @PreAuthorize("hasAnyRole('ADMIN','MANTENIMIENTO','INSTRUCTOR','RECEPCIONISTA','USER')")
    @GetMapping("/IdEmpleado/{idEmpleado}")
    public ResponseEntity<List<CheckIn>> getAllByIdEmpleado(@PathVariable("idEmpleado") int idEmpleado){
        return ResponseEntity.ok(checkInService.findByIdEmpleado(idEmpleado));
    }

    @PreAuthorize("hasAnyRole('ADMIN','MANTENIMIENTO','INSTRUCTOR','RECEPCIONISTA','USER')")
    @GetMapping("/IdEmpleado/{idEmpleado}/fecha/{fecha}")
    public ResponseEntity<List<CheckIn>> getAllByIdEmpleadoAndByFecha(@PathVariable("idEmpleado") int idEmpleado, @PathVariable("fecha") String fecha){
        return ResponseEntity.ok(checkInService.findByIdEmpleadoAndByFecha(idEmpleado,fecha));
    }

    @PreAuthorize("hasAnyRole('ADMIN','MANTENIMIENTO','INSTRUCTOR','RECEPCIONISTA','USER')")
    @PostMapping
    public ResponseEntity<Mensaje> save(@Valid @RequestBody CheckInDto dto) throws AttributeException{
        CheckIn check= checkInService.save(dto);
        String message="Check In Registered at"+ check.getHora();
        return ResponseEntity.ok(new Mensaje(HttpStatus.OK, message));
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Mensaje> delete(@PathVariable("id") int id)throws ResourceNotFoundException{
        CheckIn check= checkInService.delete(id);
        String message="CheckIn " +check.getId()+ " removed";
        return ResponseEntity.ok(new Mensaje(HttpStatus.OK, message));
    }
}
/* 
Equipo 5
Carlos Eduardo Mata Rojas
Juan Pablo jimenes Jaime
Marisol Nuñes Monasterio
Maria Fernanda Palacios Rangel
*/