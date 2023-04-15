package com.integradora.gimnasio.security.dto;

public class JwtTokenDto {
    private String token;

    public JwtTokenDto(){

    }

    public JwtTokenDto(String token){
        this.token=token;
    }

    public String getToken(){
        return token;
    }

    public void setToken(String token){
        this.token=token;
    }

}
/* 
Equipo 2
Jorge Luis Ayala Manrrique
Omar Ricardo Garay Garzia
Juan Antonio Torres Rincon
Angel Fernando Sevilla Hernández
*/