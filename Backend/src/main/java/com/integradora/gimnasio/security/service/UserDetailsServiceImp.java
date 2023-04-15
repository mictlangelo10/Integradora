package com.integradora.gimnasio.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.integradora.gimnasio.security.entity.UserEntity;
import com.integradora.gimnasio.security.repository.UserEntityRepository;

@Service
public class UserDetailsServiceImp implements UserDetailsService{
    
    @Autowired
    UserEntityRepository userEntityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userEntity = userEntityRepository.findByNombreUsuarioOrEmail(username, username);
        if(!userEntity.isPresent())
            throw new UsernameNotFoundException("Not exists user");
        return UserDetailsImp.build(userEntity.get());
    }
}
/* 
Equipo 2
Jorge Luis Ayala Manrrique
Omar Ricardo Garay Garzia
Juan Antonio Torres Rincon
Angel Fernando Sevilla Hernández
*/