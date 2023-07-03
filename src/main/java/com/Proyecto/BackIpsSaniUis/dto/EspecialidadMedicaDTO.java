package com.Proyecto.BackIpsSaniUis.dto;

import java.time.LocalDateTime;

public class EspecialidadMedicaDTO {
            
    private Long idEspecialidadMedica;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    
    public Long getIdEspecialidadMedica() {
        return idEspecialidadMedica;
    }
    public void setIdEspecialidadMedica(Long idEspecialidadMedica) {
        this.idEspecialidadMedica = idEspecialidadMedica;
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
