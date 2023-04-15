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

/* La clase claseController es una clase anotada con @RestController, 
lo que indica que se trata de un controlador de Spring que manejará las solicitudes HTTP entrantes. La anotación @RequestMapping("/Clase") 
establece la raíz de la URL para todas las solicitudes que manejará este controlador.
*/

@RestController
@RequestMapping("/Clase")
@CrossOrigin
public class claseController {
    
    @Autowired
    claseService claseService;

    @Autowired
    clienteService clienteService;
    
    /* 
    El siguiente método devuelve una respuesta HTTP ResponseEntity que contiene una lista de objetos Clase 
    obtenidos a través del servicio claseService.getAll(). El método ResponseEntity.ok() 
    devuelve una respuesta con el estado HTTP 200 OK, lo que indica que la solicitud ha sido procesada correctamente.
    */   
    
    @PreAuthorize("hasAnyRole('ADMIN','MANTENIMIENTO','INSTRUCTOR','RECEPCIONISTA','USER',)")
    @GetMapping
    public ResponseEntity<List<Clase>> getAll(){
        return ResponseEntity.ok(claseService.getAll());
    }
    
    /* 
    El siguiente método devuelve una respuesta HTTP ResponseEntity que contiene los detalles de la clase correspondiente a ese ID, 
    obtenidos a través del método claseService.getOne(id). El método ResponseEntity.ok() devuelve una respuesta con el estado HTTP 200 OK,
    lo que indica que la solicitud ha sido procesada correctamente.
    */   
    
    @PreAuthorize("hasAnyRole('ADMIN','MANTENIMIENTO','INSTRUCTOR','RECEPCIONISTA','USER')")
    @GetMapping("/{id}")
    public ResponseEntity<Clase> getOne(@PathVariable("id") int id) throws ResourceNotFoundException{
        return ResponseEntity.ok(claseService.getOne(id));
    }


    /* 
    El siguiente método es un controlador HTTP POST que recibe una solicitud para crear un nuevo objeto Clase. 
    Toma un objeto ClaseDto validado como entrada que se deserializa del cuerpo de la solicitud HTTP utilizando la anotación @RequestBody y 
    lo utiliza para crear una nueva instancia de Clase utilizando la clase Service claseService. 
    Luego, devuelve una respuesta HTTP con un mensaje de estado exitoso (HttpStatus.OK) y un objeto Mensaje que contiene un mensaje que indica que la clase 
    se ha guardado correctamente. Si hay algún error de validación de atributo, lanzará una excepción de AttributeException.
    */   
    
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Mensaje> save(@Valid @RequestBody ClaseDto dto) throws AttributeException{
        Clase clase= claseService.save(dto);
        String message=clase.getNombreClase()+ " class saved";
        return ResponseEntity.ok(new Mensaje(HttpStatus.OK, message));
    }
    
    /*
    Este método es una solicitud HTTP PUT que actualiza la información de una clase existente en la base de datos. 
    Toma dos parámetros: el primero es el ID de la clase que se va a actualizar y el segundo es el objeto ClaseDto que contiene los nuevos datos de la clase.
    
    Primero, llama al método update() del servicio de la clase para actualizar los datos de la clase en la base de datos. Luego llama al método updateCosto() 
    para actualizar el costo de la clase. Finalmente, devuelve un mensaje con el estado HTTP OK y la información de la clase actualizada en el cuerpo de la respuesta.
    */

    /* Este método actualiza una clase existente en la base de datos con la información proporcionada en el objeto ClaseDto pasado como parámetro en la solicitud HTTP.

    Primero, el método llama al método update() del servicio de Clase para actualizar los campos de la clase identificada por el parámetro de ruta "id" con la 
    información proporcionada en el objeto ClaseDto. Luego, el método llama al método updateCosto() del servicio de Clase para actualizar el costo de la clase 
    identificada por el parámetro de ruta "id" con el costo proporcionado en el objeto ClaseDto.

    Finalmente, se crea un objeto Mensaje con un mensaje de éxito y se devuelve una respuesta HTTP con un código de estado 200 y el objeto Mensaje. 
    Si la clase no existe, el método lanzará una excepción ResourceNotFoundException, y si hay algún problema con los atributos proporcionados, 
    lanzará una excepción AttributeException.
    */
    
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Mensaje> update(@PathVariable("id") int id ,@Valid @RequestBody ClaseDto dto) throws ResourceNotFoundException,AttributeException{
        Clase clase= claseService.update(id,dto);
        claseService.updateCosto(id, dto.getCosto());
        String message="updated " +clase.getNombreClase()+ " class";
        return ResponseEntity.ok(new Mensaje(HttpStatus.OK, message));
    } 
    /* 
    El método delete recibe como parámetro un id de tipo entero que representa el identificador único de una clase. Este método llama al servicio de la clase 
    claseService para eliminar la clase con el id proporcionado. Luego, crea un mensaje indicando que la clase se eliminó correctamente y 
    devuelve una respuesta HTTP 200 con el mensaje en el cuerpo. Si no se encuentra la clase con el id proporcionado, lanza una excepción ResourceNotFoundException.
    */
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Mensaje> delete(@PathVariable("id") int id)throws ResourceNotFoundException{
        Clase clase= claseService.delete(id);
        String message=clase.getNombreClase()+ " class removed";
        return ResponseEntity.ok(new Mensaje(HttpStatus.OK, message));
    }
}

/* 
Equipo 1 Autores: 
Miguel Hernández 
Daniela Cruz
*/
