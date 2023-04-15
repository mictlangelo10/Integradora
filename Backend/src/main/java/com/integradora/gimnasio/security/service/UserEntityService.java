package com.integradora.gimnasio.security.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.integradora.gimnasio.security.dto.CreateUserDto;
import com.integradora.gimnasio.security.dto.JwtTokenDto;
import com.integradora.gimnasio.security.dto.LoginUserDto;
import com.integradora.gimnasio.security.entity.UserEntity;
import com.integradora.gimnasio.security.enums.RolEnum;
import com.integradora.gimnasio.security.jwt.JwtProvider;
import com.integradora.gimnasio.security.repository.UserEntityRepository;
import com.integradora.gimnasio.exceptions.AttributeException;
import com.integradora.gimnasio.exceptions.ResourceNotFoundException;

@Service
public class UserEntityService {

    @Autowired
    UserEntityRepository userEntityRepository;
    
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    AuthenticationManager authenticationManager;

    
    public List<UserEntity> getAll(){
        return userEntityRepository.findAll();
    }

    public UserEntity getOne(int id) throws ResourceNotFoundException{
        return userEntityRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("not found"));
    }

    public List<UserEntity> getAllByRoles(List<RolEnum> roles){
        return userEntityRepository.findByRoles(roles);
    }

    public UserEntity delete(int id) throws ResourceNotFoundException{
        UserEntity user= userEntityRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("not found")); 
        userEntityRepository.delete(user);
        return user;
    }

    public UserEntity create(CreateUserDto dto) throws AttributeException{
        if(userEntityRepository.existsByNombreUsuario(dto.getNombreUsuario()))
            throw new AttributeException("Username already exist"); 
        if(userEntityRepository.existsByEmail(dto.getEmail()))
            throw new AttributeException("The email already exists");         
        int id = autoIncrement();
        List<RolEnum> roles=dto.getRoles().stream().map(rol -> RolEnum.valueOf(rol)).collect(Collectors.toList());
        String password= passwordEncoder.encode(dto.getPassword());
        UserEntity userEntity= new UserEntity(id,dto.getNombreUsuario(),dto.getFoto(),dto.getEdad(),dto.getSueldo(),dto.getTurno(),dto.getEmail(),dto.getTelefono(), password,roles);
        return userEntityRepository.save(userEntity);
    }

    public UserEntity update(int id,CreateUserDto dto) throws ResourceNotFoundException,AttributeException {
        UserEntity user = userEntityRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("not found"));
        if(userEntityRepository.existsByNombreUsuario(dto.getNombreUsuario()) && userEntityRepository.findByNombreUsuario(dto.getNombreUsuario()).get().getId() != id)
            throw new AttributeException("Username already exist"); 
        List<RolEnum> roles=dto.getRoles().stream().map(rol -> RolEnum.valueOf(rol)).collect(Collectors.toList());
        String password= passwordEncoder.encode(dto.getPassword());
        user.setNombreUsuario(dto.getNombreUsuario());
        user.setFoto(dto.getFoto());
        user.setEdad(dto.getEdad());
        user.setSueldo(dto.getSueldo());
        user.setTurno(dto.getTurno());
        user.setEmail(dto.getEmail());
        user.setTelefono(dto.getTelefono());
        user.setPassword(password);
        user.setRoles(roles);
        return userEntityRepository.save(user);
    } 

    public JwtTokenDto login(LoginUserDto dto){
        Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getNombreUsuario(), dto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token= jwtProvider.generateToken(authentication);
        return new JwtTokenDto(token);
    }

    private int autoIncrement(){
        List<UserEntity> users= userEntityRepository.findAll();
        return users.isEmpty()? 1:users.stream().max(Comparator.comparing(UserEntity::getId)).get().getId()+1;
    }


}
/* 
Equipo 2
Jorge Luis Ayala Manrrique
Omar Ricardo Garay Garzia
Juan Antonio Torres Rincon
Angel Fernando Sevilla Hernández
*/