package com.Proyecto.BackIpsSaniUis.dto;


public class MedicoDTO {

    private Long idMedico;
    private Long idUsuario;
    private String primerNombreUsuario;
    private String segundoNombreUsuario;
    private String primerApellidoUsuario;
    private String segundoApellidoUsuario;
    private Long idEspecialidadMedica;
    private String descripcionEspecialidadMedica;   

    public Long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
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

 

    public String getSegundoNombreUsuario() {
        return segundoNombreUsuario;
    }

    public void setSegundoNombreUsuario(String segundoNombreUsuario) {
        this.segundoNombreUsuario = segundoNombreUsuario;
    }

    public String getPrimerApellidoUsuario() {
        return primerApellidoUsuario;
    }

    public void setPrimerApellidoUsuario(String primerApellidoUsuario) {
        this.primerApellidoUsuario = primerApellidoUsuario;
    }

    public String getSegundoApellidoUsuario() {
        return segundoApellidoUsuario;
    }

    public void setSegundoApellidoUsuario(String segundoApellidoUsuario) {
        this.segundoApellidoUsuario = segundoApellidoUsuario;
    }




    public Long getIdEspecialidadMedica() {
        return idEspecialidadMedica;
    }

    public void setIdEspecialidadMedica(Long idEspecialidadMedica) {
        this.idEspecialidadMedica = idEspecialidadMedica;
    }

    public String getDescripcionEspecialidadMedica() {
        return descripcionEspecialidadMedica;
    }

    public void setDescripcionEspecialidadMedica(String descripcionEspecialidadMedica) {
        this.descripcionEspecialidadMedica = descripcionEspecialidadMedica;
    }

}
