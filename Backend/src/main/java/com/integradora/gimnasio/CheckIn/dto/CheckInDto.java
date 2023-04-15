package com.integradora.gimnasio.CheckIn.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CheckInDto {

    @NotNull(message = "Employee ID is required")
    private int idEmpleado;
    @NotBlank(message = "Required date")
    private String fecha;
    @NotBlank(message = "Required hour")
    private String hora;
    @NotBlank(message = "Required type")
    private String tipo;


    public CheckInDto() {
    }

    public CheckInDto(int idEmpleado,String fecha, String hora,String tipo) {
        this.idEmpleado = idEmpleado;
        this.fecha = fecha;
        this.hora = hora;
        this.tipo = tipo;
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
        String[] partesFecha = fecha.split("-"); // separar la fecha en partes
        
        // obtener el año, mes y día
        int año = Integer.parseInt(partesFecha[2]);
        int mes = Integer.parseInt(partesFecha[1]) + 1; // sumar 1 para ajustar el mes
        int dia = Integer.parseInt(partesFecha[0]);
    
        String diaCadena = String.valueOf(dia);
        String mesCadena = String.valueOf(mes);
        String añoCadena = String.valueOf(año);
        String fechaAjustada= diaCadena+'-'+mesCadena+'-'+añoCadena;
        this.fecha=fechaAjustada;
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