package com.Proyecto.BackIpsSaniUis.dto;

import java.time.LocalDateTime;

public class DetalleTratamientoDTO {
            
    private Long idDetalleTratamiento;
    private Long idTratamiento;
    private Long idMedicamento;
    private LocalDateTime fechaCreacion;

    public Long getIdDetalleTratamiento() {
        return idDetalleTratamiento;
    }

    public void setIdDetalleTratamiento(Long idDetalleTratamiento) {
        this.idDetalleTratamiento = idDetalleTratamiento;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Long getidTratamiento() {
        return idTratamiento;
    }

    public void setidTratamiento(Long idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public Long getidMedicamento() {
        return idMedicamento;
    }

    public void setidMedicamento(Long idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

}