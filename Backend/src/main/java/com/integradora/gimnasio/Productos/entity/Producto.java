package com.integradora.gimnasio.Productos.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "productos")
public class Producto {
    
    @Id
    private int id;
    private String nombreProducto;
    private String imagen;
    private int cantidad;
    private float precio;
    private boolean existencia;
    private boolean porAgotarse;
    private String nombreProvedor;
    private String categoria;
    private String tipo;
    private String codeBar;

    public Producto() {
    }

    public Producto(int id, String nombreProducto, String imagen, int cantidad, float precio, boolean existencia,
            boolean porAgotarse, String nombreProvedor, String categoria, String tipo,String codeBar) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return existencia;
    }

    public void setExistencia(boolean existencia) {
        this.existencia = existencia;
    }

    public boolean isPorAgotarse() {
        return porAgotarse;
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