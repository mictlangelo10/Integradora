package com.integradora.gimnasio.Clases.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Método para indicar que una clase es una entidad que se almacena en una colección específica de MongoDB llamada "clases".
@Document(collection = "clases")
public class Clase {
    
    //Asignando variables, definiendo una entidad en la clase.
    @Id
    private int id;
    private String nombreClase;
    private String descripcion;
    private double costo;
    private String nombreInstructor;
    private String fecha;
    private String hora;
    private int cupo;
    private String fotoClase;

    public Clase() {
    }

    // Este método es un constructor que se utiliza para inicializar las propiedades de la entidad Clase cuando se crea una nueva instancia de la clase.
    
    public Clase(int id, String nombreClase, String descripcion, double costo, String nombreInstructor, String fecha, String hora,
            int cupo, String fotoClase) {
        this.id = id;
        this.nombreClase = nombreClase;
        this.descripcion = descripcion;
        this.costo=costo;
        this.nombreInstructor = nombreInstructor;
        this.fecha = fecha;
        this.hora = hora;
        this.cupo = cupo;
        this.fotoClase = fotoClase;
    }

    
    //Definiendo métodos set y get
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
Autores del Equipo 1:
Daniela Janeth Cruz Breña 
Miguel Ángel Hernández Solís 
*/
