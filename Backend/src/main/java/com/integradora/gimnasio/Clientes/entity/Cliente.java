package com.integradora.gimnasio.Clientes.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cliente")
public class Cliente {
    
    @Id
    private int id;
    private String nombreCliente;
    private String[] nombreClase;
    private int edad;
    private String email;
    private String telefono;
    private double subcripcion;
    private double totalPagarAlMes;

    public Cliente() {
    }


    public Cliente(int id, String nombreCliente, String[] nombreClase, int edad, String email, String telefono,
            double subcripcion, double totalPagarAlMes) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.nombreClase = nombreClase;
        this.edad = edad;
        this.email = email;
        this.telefono = telefono;
        this.subcripcion = subcripcion;
        this.totalPagarAlMes = totalPagarAlMes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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