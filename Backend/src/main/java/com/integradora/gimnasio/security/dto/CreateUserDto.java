package com.integradora.gimnasio.security.dto;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


public class CreateUserDto {
    @NotBlank(message  = "Username is required")
    private String nombreUsuario;
    private String foto;
    @NotNull(message = "Age cannot be null")
    private int edad;
    @NotNull(message = "Salary cannot be null")
    private double sueldo;
    @NotBlank(message  = "Shift is required")
    private String turno;
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email")
    private String email;
    @NotBlank(message = "Telephone is required")
    private String telefono;
    @NotBlank(message = "User password is required")
    private String password;
    @NotEmpty(message = "Choose a role")
    List<String> roles;


    public CreateUserDto() {
    }

    public CreateUserDto(String nombreUsuario,String foto,int edad,double sueldo,String turno, String email,String telefono, String password, List<String> roles) {
        this.nombreUsuario = nombreUsuario;
        this.foto=foto;
        this.edad=edad;
        this.sueldo=sueldo;
        this.turno=turno;
        this.email = email;
        this.password = password;
        this.telefono=telefono;
        this.roles = roles;
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

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
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