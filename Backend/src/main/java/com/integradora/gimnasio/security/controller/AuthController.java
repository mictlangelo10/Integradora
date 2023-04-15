package com.integradora.gimnasio.security.controller;


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

import com.integradora.gimnasio.CheckIn.entity.CheckIn;
import com.integradora.gimnasio.CheckIn.service.checkInService;
import com.integradora.gimnasio.dto.Mensaje;
import com.integradora.gimnasio.exceptions.AttributeException;
import com.integradora.gimnasio.exceptions.ResourceNotFoundException;
import com.integradora.gimnasio.security.dto.CreateUserDto;
import com.integradora.gimnasio.security.dto.JwtTokenDto;
import com.integradora.gimnasio.security.dto.LoginUserDto;
import com.integradora.gimnasio.security.entity.UserEntity;
import com.integradora.gimnasio.security.enums.RolEnum;
import com.integradora.gimnasio.security.service.UserEntityService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    UserEntityService userEntityService;

    @Autowired
    checkInService checkInService;

    @PreAuthorize("hasAnyRole('ADMIN','MANTENIMIENTO','INSTRUCTOR','RECEPCIONISTA','USER')")
    @GetMapping
    public ResponseEntity<List<UserEntity>> getAll(){
        return ResponseEntity.ok(userEntityService.getAll());
    }
    
    @PreAuthorize("hasAnyRole('ADMIN','MANTENIMIENTO','INSTRUCTOR','RECEPCIONISTA','USER')")
    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getOne(@PathVariable("id") int id) throws ResourceNotFoundException{
        return ResponseEntity.ok(userEntityService.getOne(id));
    }

    
    @PreAuthorize("hasAnyRole('ADMIN','MANTENIMIENTO','INSTRUCTOR','RECEPCIONISTA','USER')")
    @GetMapping("/Rol/{roles}")
    public ResponseEntity<List<UserEntity>> getAllByProveedor(@PathVariable("roles") List<RolEnum> roles){
        return ResponseEntity.ok(userEntityService.getAllByRoles(roles));
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Mensaje> delete(@PathVariable("id") int id)throws ResourceNotFoundException{
        UserEntity user= userEntityService.delete(id);
        List<CheckIn> check= checkInService.deleteByIdEmpleado(id);
        String message="Deleted " +user.getNombreUsuario()+ " user, with "+check.size()+" registered Check-In";
        return ResponseEntity.ok(new Mensaje(HttpStatus.OK, message));
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Mensaje> update(@PathVariable("id") int id ,@Valid @RequestBody CreateUserDto dto) throws ResourceNotFoundException,AttributeException{
        UserEntity user= userEntityService.update(id, dto);
        String message="User " +user.getNombreUsuario()+ " updated";
        return ResponseEntity.ok(new Mensaje(HttpStatus.OK, message));
    } 

    @PostMapping("/create")
    public ResponseEntity<Mensaje> create(@Valid @RequestBody CreateUserDto dto) throws AttributeException{
        UserEntity userEntity= userEntityService.create(dto);
        return ResponseEntity.ok(new Mensaje(HttpStatus.OK, "User " + userEntity.getNombreUsuario() + " created"));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtTokenDto> login(@Valid @RequestBody LoginUserDto dto) throws AttributeException{
        JwtTokenDto jwtTokenDto= userEntityService.login(dto);
        return ResponseEntity.ok(jwtTokenDto);
    }
    
}
/* 
Equipo 2
Jorge Luis Ayala Manrrique
Omar Ricardo Garay Garzia
Juan Antonio Torres Rincon
Angel Fernando Sevilla Hernández
*/