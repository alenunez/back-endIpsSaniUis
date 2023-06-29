package com.Proyecto.BackIpsSaniUis.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.BackIpsSaniUis.dto.EnfermedadDTO;
import com.Proyecto.BackIpsSaniUis.mappers.EnfermedadMapper;
import com.Proyecto.BackIpsSaniUis.model.Enfermedad;
import com.Proyecto.BackIpsSaniUis.repository.EnfermedadRepository;
import com.Proyecto.BackIpsSaniUis.service.interfaces.IEnfermedadService;

@Service
public class EnfermedadServiceImpl implements IEnfermedadService{
        
    EnfermedadRepository enfermedadRepository;

    LocalDateTime today = LocalDateTime.now();

    @Override
    public Enfermedad createEnfermedad(EnfermedadDTO enfermedadDTO) {
        Enfermedad enfermedadToCreated = EnfermedadMapper.INSTANCE.toEntity(enfermedadDTO);
        enfermedadToCreated.setFechaCreacion(today);
        return enfermedadRepository.save(enfermedadToCreated);
    }

    @Override
    public List<Enfermedad> getAllEnfermedades() {
        return enfermedadRepository.findAll();
    }

    @Override
    public Enfermedad findById(Long id) {
        return enfermedadRepository.findById(id).orElse(null);
    }



    public Enfermedad updateEnfermedad(EnfermedadDTO enfermedadDTO) {
        Optional<Enfermedad> optionalEnfermedad = enfermedadRepository.findById(enfermedadDTO.getIdEnfermedad());
        if (optionalEnfermedad.isPresent()) {
            Enfermedad enfermedad = optionalEnfermedad.get();
            // Actualizar los campos necesarios del usuario

            enfermedad.setDescripcion(enfermedadDTO.getDescripcion());
            // Guardar los cambios en la base de datos
            return enfermedadRepository.save(enfermedad);

        } else {
            return null;
        }
    }

    @Override
    public Enfermedad deleteEnfermedad(Long id){
        Enfermedad enfermedad = enfermedadRepository.findById(id).orElseThrow(null);
        if(enfermedad != null){
            enfermedadRepository.delete(enfermedad);
            return enfermedad;
        }
        return null;
    }

    @Autowired
    public EnfermedadServiceImpl(EnfermedadRepository enfermedadRepository) {
        this.enfermedadRepository = enfermedadRepository;
    }

    
}
