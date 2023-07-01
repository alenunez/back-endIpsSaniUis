package com.Proyecto.BackIpsSaniUis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Proyecto.BackIpsSaniUis.model.Diagnostico;

public interface DiagnosticoRepository extends JpaRepository<Diagnostico, Long> {
    
}
