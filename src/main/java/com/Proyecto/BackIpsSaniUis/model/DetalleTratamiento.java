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
@Table(schema = "GENERAL", name = "DETALLE_TRATAMIENTO")
public class DetalleTratamiento {
            
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DETALLE_TRATAMIENTO")
    private Long idDetalleTratamiento;

    @Column(name = "FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    // Columnas llaves foráneas
    @Column(name = "ID_TRATAMIENTO", nullable = false)
    private Long idTratamiento;

    @Column(name = "ID_MEDICAMENTO", nullable = false)
    private Long idMedicamento;

    //Datos que se traen por la foránea
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TRATAMIENTO", insertable = false, updatable = false)
    private Tratamiento tratamiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_MEDICAMENTO", insertable = false, updatable = false)
    private Medicamento medicamento;


    // Getters and Setters
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

}
