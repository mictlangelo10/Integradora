package com.integradora.gimnasio.security.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.integradora.gimnasio.security.entity.UserEntity;
import com.integradora.gimnasio.security.enums.RolEnum;

@Repository
public interface UserEntityRepository extends MongoRepository<UserEntity, Integer>{
    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByEmail(String email);
    Optional<UserEntity> findByNombreUsuarioOrEmail(String nombreUsuario,String email);
    Optional<UserEntity> findByNombreUsuario(String nombreUsuario);
    List<UserEntity> findByRoles(List<RolEnum> roles);
}
/* 
Equipo 2
Jorge Luis Ayala Manrrique
Omar Ricardo Garay Garzia
Juan Antonio Torres Rincon
Angel Fernando Sevilla Hernández
*/