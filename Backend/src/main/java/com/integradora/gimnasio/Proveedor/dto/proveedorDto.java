package com.integradora.gimnasio.Proveedor.dto;



import jakarta.validation.constraints.NotBlank;

public class proveedorDto{

    @NotBlank(message = "Provider name is required")
    private String nombreProvedor;
    @NotBlank(message = "The phone number of the provider is required")
    private String telefono;
    @NotBlank(message = "The provider's email is required")
    private String email;
    @NotBlank(message = "The country of the provider is required")
    private String pais;
    @NotBlank(message = "The state of the provider is required")
    private String estado;
    @NotBlank(message = "The municipally of the provider is required")
    private String municipio;
    @NotBlank(message = "The street of the provider is required")
    private String calle;
    private String logo;
    
    public proveedorDto() {
    }

    public proveedorDto( String nombreProvedor, String telefono, String email, String logo, String pais,String estado, String municipio, String calle) {
        this.nombreProvedor = nombreProvedor;
        this.telefono = telefono;
        this.email = email;
        this.logo = logo;
        this.pais = pais;
        this.estado = estado;
        this.municipio = municipio;
        this.calle = calle;
    }

  
    public String getNombreProvedor() {
        return nombreProvedor;
    }
    public void setNombreProvedor(String nombreProvedor) {
        this.nombreProvedor = nombreProvedor;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getLogo() {
        return logo;
    }
    public void setLogo(String logo) {
        this.logo = logo;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getMunicipio() {
        return municipio;
    }
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    public String getCalle() {
        return calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }

}
/* 
Equipo 3
José Armando Gutierrez Rodriguez
Erik Daniel Méndez Enríque 
Julio Samuel Torres Reyes 
Miguel Ángel Anastacio Nava
*/