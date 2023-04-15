package com.integradora.gimnasio.security.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.integradora.gimnasio.security.enums.RolEnum;



@Document(collection = "usuarios")
public class UserEntity {
    
    @Id
    private int id;
    private String nombreUsuario;
    private String foto;
    private int edad;
    private double sueldo;
    private String turno;
    private String email;
    private String telefono;
    private String password;
    List<RolEnum> roles;

    public UserEntity(){
    }

    public UserEntity(int id, String nombreUsuario,String foto,int edad, double sueldo, String turno, String email,String telefono, String password, List<RolEnum> roles) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.foto=foto;
        this.edad=edad;
        this.sueldo=sueldo;
        this.turno=turno;
        this.email = email;
        this.telefono=telefono;
        this.password = password;
        this.roles = roles;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RolEnum> getRoles() {
        return roles;
    }

    public void setRoles(List<RolEnum> roles) {
        this.roles = roles;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    

}
/* 
Equipo 2
Jorge Luis Ayala Manrrique
Omar Ricardo Garay Garzia
Juan Antonio Torres Rincon
Angel Fernando Sevilla Hernández
*/