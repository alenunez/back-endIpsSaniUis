package com.Proyecto.BackIpsSaniUis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "GENERAL", name = "MEDICO")
public class Medico implements Serializable{
    private static final long serialVersionUID = -6115592560033265393L;

        

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MEDICO")
    private Long idMedico;

    @Column(name = "FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    // Columnas llaves foráneas
    @Column(name = "ID_USUARIO", nullable = false)
    private Long idUsuario;

    @Column(name = "ID_ESPECIALIDAD_MEDICA", nullable = false)
    private Long idEspecialidadMedica;

    //Datos que se traen por la 
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USUARIO", insertable = false, updatable = false)
    public Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ESPECIALIDAD_MEDICA", insertable = false, updatable = false)
    public EspecialidadMedica especialidadMedica;

    // Getters and Setters
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    
}
