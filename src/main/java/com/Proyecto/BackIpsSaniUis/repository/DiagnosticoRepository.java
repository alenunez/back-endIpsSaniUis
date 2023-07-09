package com.Proyecto.BackIpsSaniUis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Proyecto.BackIpsSaniUis.model.Diagnostico;

public interface DiagnosticoRepository extends JpaRepository<Diagnostico, Long> {

    @Query("SELECT c FROM Diagnostico c WHERE c.citaMedica.idCitaMedica = :idCita")
    Diagnostico findByCita(@Param("idCita") Long idCita);
    
    
}
