package com.Proyecto.BackIpsSaniUis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Proyecto.BackIpsSaniUis.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    @Query(value = "SELECT m FROM Medico m "
    + "WHERE m.especialidadMedica.idEspecialidadMedica  = :especialidad "
    )
List<Medico> findByEspecialidad(@Param("especialidad") Long especialidad);

    

}
