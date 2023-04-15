package com.integradora.gimnasio.Clases.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ClaseDto {
    
    @NotBlank(message = "Required class name")
    private String nombreClase;
    @NotBlank(message = "Required description")
    private String descripcion;
    @NotNull(message = "Required cost")
    private double costo;
    @NotBlank(message = "Required instructor name")
    private String nombreInstructor;
    @NotBlank(message = "Required date")
    private String fecha;
    @NotBlank(message = "Required hour")
    private String hora;
    @NotNull(message = "Required places")
    private int cupo;
    @NotBlank(message = "Required class photo")
    private String fotoClase;


    public ClaseDto() {
    }


    public ClaseDto( String nombreClase,String descripcion, double costo, String nombreInstructor, String fecha, String hora, int cupo,String fotoClase) {
        this.nombreClase = nombreClase;
        this.descripcion = descripcion;
        this.costo=costo;
        this.nombreInstructor = nombreInstructor;
        this.fecha = fecha;
        this.hora = hora;
        this.cupo = cupo;
        this.fotoClase = fotoClase;
    }


    public String getNombreClase() {
        return nombreClase;
    }


    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getNombreInstructor() {
        return nombreInstructor;
    }


    public void setNombreInstructor(String nombreInstructor) {
        this.nombreInstructor = nombreInstructor;
    }


    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public String getFotoClase() {
        return fotoClase;
    }

    public void setFotoClase(String fotoClase) {
        this.fotoClase = fotoClase;
    }


    public double getCosto() {
        return costo;
    }


    public void setCosto(double costo) {
        this.costo = costo;
    }



}

/* 
Equipo 1
Daniela Janeth Cruz Breña 
Miguel Ángel Hernández Solís 
Miguel Ángel Jaime García 
Filiberto Navarro Grifaldo 
*/