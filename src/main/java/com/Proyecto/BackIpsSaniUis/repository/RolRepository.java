package com.Proyecto.BackIpsSaniUis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Proyecto.BackIpsSaniUis.model.Rol;

@Repository
public interface RolRepository  extends JpaRepository<Rol, Long> {
    
}
