package com.integradora.gimnasio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{
    
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
/* 
Equipo 3
José Armando Gutierrez Rodriguez
Erik Daniel Méndez Enríque 
Julio Samuel Torres Reyes 
Miguel Ángel Anastacio Nava
*/