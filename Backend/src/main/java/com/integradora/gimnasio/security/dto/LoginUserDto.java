package com.integradora.gimnasio.security.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginUserDto {
    
    @NotBlank(message  = "Username is required")
    private String nombreUsuario;
    @NotBlank(message = "User password is required")
    private String password;

    public LoginUserDto() {
    }

    public LoginUserDto(String nombreUsuario, String password) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
/* 
Equipo 2
Jorge Luis Ayala Manrrique
Omar Ricardo Garay Garzia
Juan Antonio Torres Rincon
Angel Fernando Sevilla Hernández
*/