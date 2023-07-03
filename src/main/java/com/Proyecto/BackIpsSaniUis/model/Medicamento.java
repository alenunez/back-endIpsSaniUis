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
@Table(schema = "GENERAL", name = "MEDICAMENTO")
public class Medicamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MEDICAMENTO")
    private Long idMedicamento;

    @Column(name = "FECHA_CREACION")
    private LocalDateTime fechaCreacion;

    @Column(name = "DESCRIPCION", nullable = false)
    private String descripcion;

    // Columnas llaves foráneas
    @Column(name = "ID_MARCA_MEDICAMENTO", nullable = false)
    private Long idMarcaMedicamento;

    @Column(name = "ID_TIPO_MEDICAMENTO", nullable = false)
    private Long idTipoMedicamento;

    //Datos que se traen por la foránea
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_MARCA_MEDICAMENTO", insertable = false, updatable = false)
    private MarcaMedicamento marcaMedicamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TIPO_MEDICAMENTO", insertable = false, updatable = false)
    private TipoMedicamento tipoMedicamento;

    // Getters and Setters
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
