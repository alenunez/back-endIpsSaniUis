package com.Proyecto.BackIpsSaniUis.dto;

import java.time.LocalDateTime;

public class MarcaMedicamentoDTO {
    
    private Long idMarcaMedicamento;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    
    public Long getIdMarcaMedicamento() {
        return idMarcaMedicamento;
    }
    public void setIdMarcaMedicamento(Long idMarcaMedicamento) {
        this.idMarcaMedicamento = idMarcaMedicamento;
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
