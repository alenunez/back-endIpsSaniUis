package com.Proyecto.BackIpsSaniUis.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.BackIpsSaniUis.dto.TratamientoDTO;
import com.Proyecto.BackIpsSaniUis.mappers.TratamientoMapper;
import com.Proyecto.BackIpsSaniUis.model.Tratamiento;
import com.Proyecto.BackIpsSaniUis.repository.TratamientoRepository;
import com.Proyecto.BackIpsSaniUis.service.interfaces.ITratamientoService;

@Service
public class TratamientoServiceImpl implements ITratamientoService {
        
    TratamientoRepository tratamientoRepository;
    LocalDateTime today = LocalDateTime.now();

    @Override
    public Tratamiento createTratamiento(TratamientoDTO tratamientoDTO) {
        Tratamiento tratamientoToCreated = TratamientoMapper.INSTANCE.toEntity(tratamientoDTO);
        tratamientoToCreated.setFechaCreacion(today);
        return tratamientoRepository.save(tratamientoToCreated);
    }

    @Override
    public List<Tratamiento> getAllTratamientos() {
        return tratamientoRepository.findAll();
    }

    @Override
    public Tratamiento findById(Long id) {
        return tratamientoRepository.findById(id).orElse(null);
    }

    public Tratamiento updateTratamiento(TratamientoDTO tratamientoDTO) {
        Optional<Tratamiento> optionalTratamiento = tratamientoRepository.findById(tratamientoDTO.getIdTratamiento());
        if (optionalTratamiento.isPresent()) {
            Tratamiento tratamiento = optionalTratamiento.get();
            // Actualizar los campos necesarios del tratamiento

            tratamiento.setDescripcion(tratamientoDTO.getDescripcion());
            // Guardar los cambios en la base de datos
            return tratamientoRepository.save(tratamiento);

        } else {
            return null;
        }
    }

    @Override
    public Tratamiento deleteTratamiento(Long id){
        Tratamiento tratamiento = tratamientoRepository.findById(id).orElseThrow(null);
        if(tratamiento != null){
            tratamientoRepository.delete(tratamiento);
            return tratamiento;
        }
        return null;
    }

    @Autowired
    public TratamientoServiceImpl(TratamientoRepository tratamientoRepository) {
        this.tratamientoRepository = tratamientoRepository;
    }

}
