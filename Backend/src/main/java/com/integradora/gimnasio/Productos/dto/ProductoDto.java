package com.integradora.gimnasio.Productos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductoDto{

    @NotBlank(message = "Required product name")
    private String nombreProducto;
    @NotBlank(message = "Required image")
    private String imagen;
    @NotNull(message = "Quantity cannot be null")
    private int cantidad;
    @NotNull(message = "The price cannot be null")
    private float precio;
    boolean existencia;
    boolean porAgotarse;
    @NotBlank(message = "Required provider name")
    private String nombreProvedor;
    @NotBlank(message = "Category is required")
    private String categoria;
    @NotBlank(message = "The type is required")
    private String tipo;
    @NotBlank(message = "The CodeBar is required")
    private String codeBar;

    
    public ProductoDto() {
    }

    public ProductoDto(String nombreProducto, String imagen, int cantidad, float precio, boolean existencia,
            boolean porAgotarse, String nombreProvedor, String categoria, String tipo, String codeBar) {
        this.nombreProducto = nombreProducto;
        this.imagen = imagen;
        this.cantidad = cantidad;
        this.precio = precio;
        this.existencia = existencia;
        this.porAgotarse = porAgotarse;
        this.nombreProvedor = nombreProvedor;
        this.categoria=categoria;
        this.tipo=tipo;
        this.codeBar=codeBar;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public boolean isExistencia() {
        if(cantidad>0){
            return true;
        }else{
           return false;
        }
    }

    public void setExistencia(boolean existencia) {
        this.existencia = existencia;
    }

    public boolean isPorAgotarse() {
        if(cantidad <= 10){
            return true;
        }else{
            return false;
        }
    }

    public void setPorAgotarse(boolean porAgotarse) {
        this.porAgotarse = porAgotarse;
    }

    public String getNombreProvedor() {
        return nombreProvedor;
    }

    public void setNombreProvedor(String nombreProvedor) {
        this.nombreProvedor = nombreProvedor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodeBar() {
        return codeBar;
    }

    public void setCodeBar(String codeBar) {
        this.codeBar = codeBar;
    }
    
    
    
}
/* 
Equipo 3
José Armando Gutierrez Rodriguez
Erik Daniel Méndez Enríque 
Julio Samuel Torres Reyes 
Miguel Ángel Anastacio Nava
*/