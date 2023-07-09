package com.Proyecto.BackIpsSaniUis.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class DiagnosticoDTO {
        
    private Long idDiagnostico;
    private String comentario;
    private Long idCitaMedica;
    private Long idEnfermedad;
    private String descripcionEnfermedad;
    private Date fechaCitaCitaMedica;
    private LocalDateTime fechaCreacion;

    public Long getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(Long idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
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

    public Long getidEnfermedad() {
        return idEnfermedad;
    }

    public void setidEnfermedad(Long idEnfermedad) {
        this.idEnfermedad = idEnfermedad;
    }

    public String getDescripcionEnfermedad() {
        return descripcionEnfermedad;
    }

    public void setDescripcionEnfermedad(String descripcionEnfermedad) {
        this.descripcionEnfermedad = descripcionEnfermedad;
    }

}
