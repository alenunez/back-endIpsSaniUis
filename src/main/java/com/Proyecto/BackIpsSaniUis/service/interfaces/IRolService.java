package com.Proyecto.BackIpsSaniUis.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Proyecto.BackIpsSaniUis.dto.RolDTO;
import com.Proyecto.BackIpsSaniUis.model.Rol;

@Service
public interface IRolService {

    public Rol createRol(RolDTO rolDTO);

    public List<Rol> getAllRol();

    public Rol findById(Long id);

    public Rol updateRol(RolDTO rolDTO);

    public Rol deleteRol(Long id);
    
}
