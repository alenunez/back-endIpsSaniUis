package com.Proyecto.BackIpsSaniUis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "GENERAL", name = "DIAGNOSTICO")
public class Diagnostico {
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DIAGNOSTICO")
    private Long idDiagnostico;

    @Column(name = "FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @Column(name = "COMENTARIO", nullable = false)
    private String comentario;

    // Columnas llaves foráneas
    @Column(name = "ID_CITA_MEDICA", nullable = false)
    public Long idCitaMedica;

    @Column(name = "ID_ENFERMEDAD", nullable = false)
    private Long idEnfermedad;

    //Datos que se traen por la foránea
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CITA_MEDICA", insertable = false, updatable = false)
    private CitaMedica citaMedica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ENFERMEDAD", insertable = false, updatable = false)
    private Enfermedad enfermedad;


    // Getters and Setters
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

}
