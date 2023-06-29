package com.Proyecto.BackIpsSaniUis.dto;

import java.time.LocalDateTime;

public class EnfermedadDTO {
        
    private Long idEnfermedad;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    
    public Long getIdEnfermedad() {
        return idEnfermedad;
    }
    public void setIdEnfermedad(Long idEnfermedad) {
        this.idEnfermedad = idEnfermedad;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

  
}
