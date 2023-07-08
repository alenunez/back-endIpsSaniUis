package com.Proyecto.BackIpsSaniUis.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class CitaMedicaDTO {

    private Long idCitaMedica;
    private Date fechaCita;
    private LocalTime horaCita;

    private LocalDateTime fechaCreacion;
    private Long idUsuario;
    private String primerNombreUsuario;
    private String primerNombreMedico;
    private String primerApellidoMedico;

    private String primerApellidoUsuario;

    private Long idMedico;

    public Long getIdCitaMedica() {
        return idCitaMedica;
    }

    public void setIdCitaMedica(Long idCitaMedica) {
        this.idCitaMedica = idCitaMedica;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPrimerNombreUsuario() {
        return primerNombreUsuario;
    }

    public void setPrimerNombreUsuario(String primerNombreUsuario) {
        this.primerNombreUsuario = primerNombreUsuario;
    }

    public String getPrimerApellidoUsuario() {
        return primerApellidoUsuario;
    }

    public String getPrimerNombreMedico() {
        return primerNombreMedico;
    }

    public void setPrimerNombreMedico(String primerNombreMedico) {
        this.primerNombreMedico = primerNombreMedico;
    }

    public String getPrimerApellidoMedico() {
        return primerApellidoMedico;
    }

    public void setPrimerApellidoMedico(String primerApellidoMedico) {
        this.primerApellidoMedico = primerApellidoMedico;
    }

    public void setPrimerApellidoUsuario(String primerApellidoUsuario) {
        this.primerApellidoUsuario = primerApellidoUsuario;
    }

    public Long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
    }

    public LocalTime getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(LocalTime horaCita) {
        this.horaCita = horaCita;
    }
    

}
