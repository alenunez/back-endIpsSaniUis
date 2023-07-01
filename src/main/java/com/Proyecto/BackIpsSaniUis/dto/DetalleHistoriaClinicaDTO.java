package com.Proyecto.BackIpsSaniUis.dto;

import java.time.LocalDateTime;

public class DetalleHistoriaClinicaDTO {
            
    private Long idDetalleHistoriaClinica;
    private Long idCitaMedica;
    private Long idHistoriaClinica;
    private LocalDateTime fechaCitaCitaMedica;
    private LocalDateTime fechaCreacion;

    public Long getIdDetalleHistoriaClinica() {
        return idDetalleHistoriaClinica;
    }

    public void setIdDetalleHistoriaClinica(Long idDetalleHistoriaClinica) {
        this.idDetalleHistoriaClinica = idDetalleHistoriaClinica;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Long getidCitaMedica() {
        return idCitaMedica;
    }

    public void setidCitaMedica(Long idCitaMedica) {
        this.idCitaMedica = idCitaMedica;
    }

    public LocalDateTime getFechaCitaCitaMedica() {
        return fechaCitaCitaMedica;
    }

    public void setFechaCitaCitaMedica(LocalDateTime fechaCitaCitaMedica) {
        this.fechaCitaCitaMedica = fechaCitaCitaMedica;
    }

    public Long getidHistoriaClinica() {
        return idHistoriaClinica;
    }

    public void setidHistoriaClinica(Long idHistoriaClinica) {
        this.idHistoriaClinica = idHistoriaClinica;
    }

}
