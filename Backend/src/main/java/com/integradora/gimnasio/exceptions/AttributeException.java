package com.integradora.gimnasio.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AttributeException extends Exception{
    public AttributeException(String message) {
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