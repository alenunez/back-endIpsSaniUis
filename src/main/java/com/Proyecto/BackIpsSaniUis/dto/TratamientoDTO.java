package com.Proyecto.BackIpsSaniUis.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class TratamientoDTO {
    
    private Long idTratamiento;
    private String descripcion;
    private Long idCitaMedica;
    private Date fechaCitaCitaMedica;
    private LocalDateTime fechaCreacion;

    public Long getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(Long idTratamiento) {
        this.idTratamiento = idTratamiento;
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

    public Long getidCitaMedica() {
        return idCitaMedica;
    }

    public void setidCitaMedica(Long idCitaMedica) {
        this.idCitaMedica = idCitaMedica;
    }

    public Date getFechaCitaCitaMedica() {
        return fechaCitaCitaMedica;
    }

    public void setFechaCitaCitaMedica(Date fechaCitaCitaMedica) {
        this.fechaCitaCitaMedica = fechaCitaCitaMedica;
    }
}
