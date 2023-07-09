package com.Proyecto.BackIpsSaniUis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Proyecto.BackIpsSaniUis.model.Tratamiento;

public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {

    @Query(value = "SELECT m FROM Tratamiento m "
    + "WHERE m.citaMedica.idCitaMedica  = :aidCitaMedica "
    )
Tratamiento findByCita(@Param("aidCitaMedica") Long acitaMedica);
    
}
