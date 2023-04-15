package com.integradora.gimnasio.CheckIn.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.integradora.gimnasio.CheckIn.entity.CheckIn;

@Repository
public interface checkInRepository extends MongoRepository<CheckIn,Integer>{
    List<CheckIn> findByIdEmpleado(int idEmpleado);
    List<CheckIn> deleteByIdEmpleado(int idEmpleado);
    List<CheckIn> findByIdEmpleadoAndFecha(int idEmpleado, String fecha);
}
/* 
Equipo 5
Carlos Eduardo Mata Rojas
Juan Pablo jimenes Jaime
Marisol Nuñes Monasterio
Maria Fernanda Palacios Rangel
*/