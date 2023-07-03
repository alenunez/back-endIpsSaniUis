package com.Proyecto.BackIpsSaniUis.dto;

import java.time.LocalDateTime;

public class TipoMedicamentoDTO {
        
    private Long idTipoMedicamento;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    
    public Long getIdTipoMedicamento() {
        return idTipoMedicamento;
    }
    public void setIdTipoMedicamento(Long idTipoMedicamento) {
        this.idTipoMedicamento = idTipoMedicamento;
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
