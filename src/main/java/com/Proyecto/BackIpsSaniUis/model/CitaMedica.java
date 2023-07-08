package com.Proyecto.BackIpsSaniUis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "GENERAL", name = "CITA_MEDICA")
public class CitaMedica {
                
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CITA_MEDICA")
    private Long idCitaMedica;

    @Column(name = "FECHA_CITA")
    @Temporal(TemporalType.DATE)
    private Date fechaCita;

    @Column(name = "HORA_CITA")
    private LocalTime horaCita;

    @Column(name = "FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    // Columnas llaves foráneas
    @Column(name = "ID_USUARIO", nullable = false)
    private Long idUsuario;

    @Column(name = "ID_MEDICO", nullable = false)
    private Long idMedico;

    //Datos que se traen por la foránea
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USUARIO", insertable = false, updatable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_MEDICO", insertable = false, updatable = false)
    private Medico medico;

    // Getters and Setters
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
    
    
}
