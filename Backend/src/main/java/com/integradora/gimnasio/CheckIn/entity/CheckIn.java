package com.integradora.gimnasio.CheckIn.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CheckIn")
public class CheckIn {
    
    @Id
    private int id;
    private int idEmpleado;
    private String fecha;
    private String hora;
    private String tipo;

    public CheckIn() {
    }

    public CheckIn(int id, int idEmpleado, String fecha, String hora, String tipo) {
        this.id = id;
        this.idEmpleado = idEmpleado;
        this.fecha = fecha;
        this.hora = hora;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
/* 
Equipo 5
Carlos Eduardo Mata Rojas
Juan Pablo jimenes Jaime
Marisol Nuñes Monasterio
Maria Fernanda Palacios Rangel
*/