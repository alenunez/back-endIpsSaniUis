package com.Proyecto.BackIpsSaniUis.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.BackIpsSaniUis.dto.RolDTO;
import com.Proyecto.BackIpsSaniUis.mappers.RolMapper;
import com.Proyecto.BackIpsSaniUis.model.Rol;
import com.Proyecto.BackIpsSaniUis.repository.RolRepository;
import com.Proyecto.BackIpsSaniUis.service.interfaces.IRolService;


@Service
public class RolServiceImpl implements IRolService {

    RolRepository rolRepository;

    LocalDateTime today = LocalDateTime.now();

    @Override
    public Rol createRol(RolDTO rolDTO) {
        Rol rolToCreated = RolMapper.INSTANCE.rolDTOToRol(rolDTO);
        rolToCreated.setFechaCreacion(today);
        return rolRepository.save(rolToCreated);
    }

    @Override
    public List<Rol> getAllRol() {
        return rolRepository.findAll();
    }

    @Override
    public Rol findById(Long id) {
        return rolRepository.findById(id).orElse(null);
    }



    public Rol updateRol(RolDTO rolDTO) {
        Optional<Rol> optionalRol = rolRepository.findById(rolDTO.getIdRol());
        if (optionalRol.isPresent()) {
            Rol rol = optionalRol.get();
            // Actualizar los campos necesarios del usuario

            rol.setDescripcion(rolDTO.getDescripcion());
            // Guardar los cambios en la base de datos
            return rolRepository.save(rol);

        } else {
            return null;
        }
    }

    @Override
    public Rol deleteRol(Long id){
        Rol rol = rolRepository.findById(id).orElseThrow(null);
        if(rol != null){
            rolRepository.delete(rol);
            return rol;
        }
        return null;
    }

    @Autowired
    public RolServiceImpl(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    
}
