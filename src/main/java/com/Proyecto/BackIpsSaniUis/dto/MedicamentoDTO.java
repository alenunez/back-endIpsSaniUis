package com.Proyecto.BackIpsSaniUis.dto;

import java.time.LocalDateTime;

public class MedicamentoDTO {

    private Long idMedicamento;
    private String descripcion;    
    private Long idMarcaMedicamento;
    private Long idTipoMedicamento;
    private String descripcionMarcaMedicamento;
    private String descripcionTipoMedicamento;
    private LocalDateTime fechaCreacion;


    public Long getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(Long idMedicamento) {
        this.idMedicamento = idMedicamento;
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

    public Long getIdMarcaMedicamento() {
        return idMarcaMedicamento;
    }
    public void setIdMarcaMedicamento(Long idMarcaMedicamento) {
        this.idMarcaMedicamento = idMarcaMedicamento;
    }
    public String getDescripcionMarcaMedicamento() {
        return descripcionMarcaMedicamento;
    }
    public void setDescripcionMarcaMedicamento(String descripcionMarcaMedicamento) {
        this.descripcionMarcaMedicamento = descripcionMarcaMedicamento;
    }

    public Long getIdTipoMedicamento() {
        return idTipoMedicamento;
    }
    public void setIdTipoMedicamento(Long idTipoMedicamento) {
        this.idTipoMedicamento = idTipoMedicamento;
    }
    public String getDescripcionTipoMedicamento() {
        return descripcionTipoMedicamento;
    }
    public void setDescripcionTipoMedicamento(String descripcionTipoMedicamento) {
        this.descripcionTipoMedicamento = descripcionTipoMedicamento;
    }


}
