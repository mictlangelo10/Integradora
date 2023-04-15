package com.integradora.gimnasio.Clientes.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.integradora.gimnasio.Clases.entity.Clase;
import com.integradora.gimnasio.Clases.repository.claseRepository;
import com.integradora.gimnasio.Clientes.dto.ClienteDto;
import com.integradora.gimnasio.Clientes.entity.Cliente;
import com.integradora.gimnasio.Clientes.repository.clienteRepository;
import com.integradora.gimnasio.exceptions.AttributeException;
import com.integradora.gimnasio.exceptions.ResourceNotFoundException;

@Service
public class clienteService {
    

    @Autowired
    clienteRepository clienteRepository;

    @Autowired
    claseRepository claseRepository;

    // Método para para obtener todos los clientes
    public List<Cliente> getAll(){
        return clienteRepository.findAll();
    }

    // Método para obtener clases por nombre
    public List<Cliente> getAllByNombreClase(String nombreClase){
        return clienteRepository.findByNombreClase(nombreClase);
    }

    // Método para obtener un solo cliente
    public Cliente getOne(int id) throws ResourceNotFoundException{
        return clienteRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("not found"));
    }

    // Método para crear y guardar clientes.
    public Cliente save(ClienteDto dto) throws AttributeException, ResourceNotFoundException{
        if(clienteRepository.existsByNombreCliente(dto.getNombreCliente()))
            throw new AttributeException("That product name already exists");
        if(clienteRepository.existsByEmail(dto.getEmail()))
            throw new AttributeException("The email is already registered");
        // calcular la suma del costo de las clases registradas por el cliente
        double costoTotalPorClase = 0.0;
        double costoTotal= 0.0;
        for (String nombreClase : dto.getNombreClase()) {
        Clase clase = claseRepository.findByNombreClase(nombreClase).orElseThrow(() -> new ResourceNotFoundException("Class not found"));
        costoTotalPorClase += clase.getCosto(); 
        }
        costoTotal= costoTotalPorClase + dto.getSubcripcion();
        int id=autoIncrement();
        Cliente cliente = new Cliente(
            id,
            dto.getNombreCliente(),
            dto.getNombreClase(),
            dto.getEdad(),
            dto.getEmail(),
            dto.getTelefono(),
            dto.getSubcripcion(),
            costoTotal
        );
        return clienteRepository.save(cliente);    
    }

    // Método para modificar y actualiza clientes, por medio de su id
    public Cliente update(int id,ClienteDto dto) throws ResourceNotFoundException,AttributeException {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("not found"));
        if(clienteRepository.existsByNombreCliente(dto.getNombreCliente()) && clienteRepository.findByNombreCliente(dto.getNombreCliente()).get().getId() != id)
            throw new AttributeException("That Client name already exists"); 
        // calcular la suma del costo de las clases registradas por el cliente
        double costoTotalPorClase = 0.0;
        double costoTotal = 0.0;
        for (String nombreClase : dto.getNombreClase()) {
        Clase clase = claseRepository.findByNombreClase(nombreClase).orElseThrow(() -> new ResourceNotFoundException("Class not found"));
        costoTotalPorClase += clase.getCosto();
        }
        costoTotal = costoTotalPorClase + dto.getSubcripcion();
        cliente.setNombreCliente(dto.getNombreCliente());
        cliente.setNombreClase(dto.getNombreClase());
        cliente.setEdad(dto.getEdad());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefono(dto.getTelefono());
        cliente.setSubcripcion(dto.getSubcripcion());
        cliente.setTotalPagarAlMes(costoTotal);
        return clienteRepository.save(cliente);
    } 


    // Método para eliminar un cliente, por medio de su id
    public Cliente delete(int id) throws ResourceNotFoundException{
        Cliente cliente= clienteRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("not found")); 
        clienteRepository.delete(cliente);
        return cliente;
    }

    // Método para incrementar el id de uno en uno
    private int autoIncrement(){
        List<Cliente> cliente= clienteRepository.findAll();
        return cliente.isEmpty()? 1:cliente.stream().max(Comparator.comparing(Cliente::getId)).get().getId()+1;
    }
}

/* 
Autore del Equipo 1
Daniela Janeth Cruz Breña 
Miguel Ángel Hernández Solís 
*/
