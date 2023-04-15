package com.integradora.gimnasio.CheckIn.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integradora.gimnasio.CheckIn.dto.CheckInDto;
import com.integradora.gimnasio.CheckIn.entity.CheckIn;
import com.integradora.gimnasio.CheckIn.repository.checkInRepository;
import com.integradora.gimnasio.exceptions.AttributeException;
import com.integradora.gimnasio.exceptions.ResourceNotFoundException;

@Service
public class checkInService {
    
    @Autowired
    checkInRepository checkInRepository;

    public List<CheckIn> getAll(){
        return checkInRepository.findAll();
    }

    public List<CheckIn> findByIdEmpleado(int idEmpleado){
        return checkInRepository.findByIdEmpleado(idEmpleado);
    }

    public List<CheckIn> findByIdEmpleadoAndByFecha(int idEmpleado, String fecha){
        return checkInRepository.findByIdEmpleadoAndFecha(idEmpleado,fecha);
    }


    public CheckIn getOne(int id) throws ResourceNotFoundException{
        return checkInRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("not found"));
    }

    public CheckIn save(CheckInDto dto) throws AttributeException{
        int id=autoIncrement();
        CheckIn check = new CheckIn(
            id,
            dto.getIdEmpleado(),
            dto.getFecha(),
            dto.getHora(),
            dto.getTipo()
        );
        return checkInRepository.save(check);    
    }

    public CheckIn delete(int id) throws ResourceNotFoundException{
        CheckIn check= checkInRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("not found")); 
        checkInRepository.delete(check);
        return check;
    }

    public List<CheckIn> deleteByIdEmpleado(int idEmpleado) throws ResourceNotFoundException{
        List<CheckIn> check= checkInRepository.findByIdEmpleado(idEmpleado); 
        checkInRepository.deleteByIdEmpleado(idEmpleado);
        return check;
    }

    //Incrementar el id de uno en uno
    private int autoIncrement(){
        List<CheckIn> products= checkInRepository.findAll();
        return products.isEmpty()? 1:products.stream().max(Comparator.comparing(CheckIn::getId)).get().getId()+1;
    }
}
/* 
Equipo 5
Carlos Eduardo Mata Rojas
Juan Pablo jimenes Jaime
Marisol Nuñes Monasterio
Maria Fernanda Palacios Rangel
*/