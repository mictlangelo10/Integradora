package com.integradora.gimnasio.Clases.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integradora.gimnasio.Clases.dto.ClaseDto;
import com.integradora.gimnasio.Clases.entity.Clase;
import com.integradora.gimnasio.Clases.repository.claseRepository;
import com.integradora.gimnasio.Clientes.entity.Cliente;
import com.integradora.gimnasio.Clientes.repository.clienteRepository;
import com.integradora.gimnasio.exceptions.AttributeException;
import com.integradora.gimnasio.exceptions.ResourceNotFoundException;

@Service
public class claseService {
    
    // Método para realizar inyecciones de dependencias.
    @Autowired
    claseRepository claseRepository;

    @Autowired
    clienteRepository clienteRepository;
    
    // Método que obtiene todas las clases existentes en el sistema
    public List<Clase> getAll(){
        return claseRepository.findAll();
    }
    
    // Método que obtiene una clase, por medio del id de la misma.
    public Clase getOne(int id) throws ResourceNotFoundException{
        return claseRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("not found"));
    }

    // Método que permite agregar una clase al sistema, también conocido como método post
    public Clase save(ClaseDto dto) throws AttributeException{
        if(claseRepository.existsByNombreClase(dto.getNombreClase()))
            throw new AttributeException("That class name already exists");
        int id=autoIncrement();
        Clase clase = new Clase(
            id,
            dto.getNombreClase(),
            dto.getDescripcion(),
            dto.getCosto(),
            dto.getNombreInstructor(),
            dto.getFecha(),
            dto.getHora(),
            dto.getCupo(),
            dto.getFotoClase()
        );
        return claseRepository.save(clase);    
    }


    // Método que actualiza una clase, la ubica por medio del id y de esta madera permite modificar la misma.
    public Clase update(int id,ClaseDto dto) throws ResourceNotFoundException,AttributeException {
        Clase clase = claseRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("not found"));
        if(claseRepository.existsByNombreClase(dto.getNombreClase()) && claseRepository.findByNombreClase(dto.getNombreClase()).get().getId() != id)
            throw new AttributeException("That class name already exists"); 
        clase.setNombreClase(dto.getNombreClase());
        clase.setDescripcion(dto.getDescripcion());
        clase.setCosto(dto.getCosto());
        clase.setNombreInstructor(dto.getNombreInstructor());
        clase.setFecha(dto.getFecha());
        clase.setHora(dto.getHora());
        clase.setCupo(dto.getCupo());
        clase.setFotoClase(dto.getFotoClase());
        return claseRepository.save(clase);
    } 
    
    // Método que actualiza el costo de una clase por medio de su id 
    public void updateCosto(int claseId, double nuevoCosto) throws ResourceNotFoundException {
        Clase clase = claseRepository.findById(claseId).orElseThrow(() -> new ResourceNotFoundException("Clase not found"));
        clase.setCosto(nuevoCosto);
        claseRepository.save(clase);
    
        // Actualizar totalPagarAlMes de los clientes que tienen esta clase
        List<Cliente> clientes = clienteRepository.findByNombreClase(clase.getNombreClase());
        for (Cliente cliente : clientes) {
            double costoTotalPorClase = 0.0;
            double costoTotal = 0.0;
            for (String nombreClase : cliente.getNombreClase()) {
                Clase c = claseRepository.findByNombreClase(nombreClase).orElseThrow(() -> new ResourceNotFoundException("Class not found"));
                costoTotalPorClase += c.getCosto();
            }
            costoTotal= costoTotalPorClase+ cliente.getSubcripcion();
            cliente.setTotalPagarAlMes(costoTotal);
            clienteRepository.save(cliente);
        }
    }

    // Método que elimina una clase por medio de su id
    public Clase delete(int id) throws ResourceNotFoundException{
        Clase clase= claseRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("not found")); 
        claseRepository.delete(clase);
        return clase;
    }

    // Método que incrementa el id de uno en uno
    private int autoIncrement(){
        List<Clase> clases= claseRepository.findAll();
        return clases.isEmpty()? 1:clases.stream().max(Comparator.comparing(Clase::getId)).get().getId()+1;
    }
    
}

/* 
Autores del Equipo 1:
Daniela Janeth Cruz Breña 
Miguel Ángel Hernández Solís 
*/
