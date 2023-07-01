package com.Proyecto.BackIpsSaniUis.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.BackIpsSaniUis.dto.CitaMedicaDTO;
import com.Proyecto.BackIpsSaniUis.mappers.CitaMedicaMapper;
import com.Proyecto.BackIpsSaniUis.model.CitaMedica;
import com.Proyecto.BackIpsSaniUis.repository.CitaMedicaRepository;
import com.Proyecto.BackIpsSaniUis.service.interfaces.ICitaMedicaService;

@Service
public class CitaMedicaServiceImpl implements ICitaMedicaService {
                
    CitaMedicaRepository citaMedicaRepository;
    LocalDateTime today = LocalDateTime.now();

    @Override
    public CitaMedica createCitaMedica(CitaMedicaDTO citaMedicaDTO) {
        CitaMedica citaMedicaToCreate = CitaMedicaMapper.INSTANCE.toEntity(citaMedicaDTO);
        citaMedicaToCreate.setFechaCreacion(today); // Asignación de fecha de creación automática
        citaMedicaToCreate.setFechaCita(citaMedicaDTO.getFechaCita()); // Asignación de fecha de la cita
        return citaMedicaRepository.save(citaMedicaToCreate);
    }

    @Override
    public List<CitaMedica> getAllCitaMedica() {
        return citaMedicaRepository.findAll();
    }

    @Override
    public CitaMedica findById(Long id) {
        return citaMedicaRepository.findById(id).orElse(null);
    }

    public CitaMedica updateCitaMedica(CitaMedicaDTO citaMedicaDTO) {
        Optional<CitaMedica> optionalCitaMedica = citaMedicaRepository.findById(citaMedicaDTO.getIdCitaMedica());
        if (optionalCitaMedica.isPresent()) {
            CitaMedica citaMedica = optionalCitaMedica.get();
            // Actualizar los campos necesarios de la cita medica

            citaMedica.setFechaCita(citaMedicaDTO.getFechaCita());
            // Guardar los cambios en la base de datos
            return citaMedicaRepository.save(citaMedica);

        } else {
            return null;
        }
    }

    @Override
    public CitaMedica deleteCitaMedica(Long id){
        CitaMedica  citaMedica = citaMedicaRepository.findById(id).orElseThrow(null);
        if(citaMedica != null){
            citaMedicaRepository.delete(citaMedica);
            return citaMedica;
        }
        return null;
    }

    @Autowired
    public CitaMedicaServiceImpl(CitaMedicaRepository citaMedicaRepository) {
        this.citaMedicaRepository = citaMedicaRepository;
    }

}
