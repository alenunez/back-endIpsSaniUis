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
@Table(schema = "GENERAL", name = "DETALLE_HISTORIA_CLINICA")
public class DetalleHistoriaClinica {
            
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DETALLE_HISTORIA_CLINICA")
    private Long idDetalleHistoriaClinica;

    @Column(name = "FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    // Columnas llaves foráneas
    @Column(name = "ID_CITA_MEDICA", nullable = false)
    private Long idCitaMedica;

    @Column(name = "ID_HISTORIA_CLINICA", nullable = false)
    private Long idHistoriaClinica;

    //Datos que se traen por la foránea
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CITA_MEDICA", insertable = false, updatable = false)
    private CitaMedica citaMedica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_HISTORIA_CLINICA", insertable = false, updatable = false)
    private HistoriaClinica historiaClinica;


    // Getters and Setters
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

}
