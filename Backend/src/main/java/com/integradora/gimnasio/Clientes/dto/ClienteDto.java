package com.integradora.gimnasio.Clientes.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ClienteDto {

    
    @NotBlank(message = "Required customer name")
    private String nombreCliente;
    private String[] nombreClase;
    @NotNull(message = "Required age")
    private int edad;
    @NotBlank(message = "Required Email")
    @Email(message = "Invalid email")
    private String email;
    @NotBlank(message = "Required phone")
    private String telefono;
    @NotNull(message = "Required subscription")
    private double subcripcion;
    private double totalPagarAlMes;

    public ClienteDto() {
    }

    public ClienteDto(String nombreCliente, String[] nombreClase, int edad, String email, String telefono, double subcripcion, double totalPagarAlMes) {
        this.nombreCliente = nombreCliente;
        this.nombreClase = nombreClase;
        this.edad = edad;
        this.email = email;
        this.telefono = telefono;
        this.subcripcion = subcripcion;
        this.totalPagarAlMes = totalPagarAlMes;
    }



    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String[] getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String[] nombreClase) {
        this.nombreClase = nombreClase;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getSubcripcion() {
        return subcripcion;
    }

    public void setSubcripcion(double subcripcion) {
        this.subcripcion = subcripcion;
    }

    public double getTotalPagarAlMes() {
        return totalPagarAlMes;
    }

    public void setTotalPagarAlMes(double totalPagarAlMes) {
        this.totalPagarAlMes = totalPagarAlMes;
    }

    
}

/* 
Equipo 1
Daniela Janeth Cruz Breña 
Miguel Ángel Hernández Solís 
Miguel Ángel Jaime García 
Filiberto Navarro Grifaldo 
*/