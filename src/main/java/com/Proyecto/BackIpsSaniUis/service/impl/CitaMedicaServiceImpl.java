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
        List<CitaMedica> citasMedicos = citaMedicaRepository.findByMedicoAndFechaAndHoraCita(citaMedicaDTO.getIdMedico(), citaMedicaDTO.getFechaCita(), citaMedicaDTO.getHoraCita());
        List<CitaMedica> citasUsuarios = citaMedicaRepository.findByUsuarioAndFechaAndHoraCita(citaMedicaDTO.getIdUsuario(), citaMedicaDTO.getFechaCita(), citaMedicaDTO.getHoraCita());
    
        if (citasMedicos.isEmpty() && citasUsuarios.isEmpty()) {
            CitaMedica citaMedicaToCreate = CitaMedicaMapper.INSTANCE.toEntity(citaMedicaDTO);
            citaMedicaToCreate.setFechaCreacion(today); // Asignar fecha y hora de creación
            citaMedicaToCreate.setFechaCita(citaMedicaDTO.getFechaCita()); // Asignar fecha de la cita
            citaMedicaToCreate.setHoraCita(citaMedicaDTO.getHoraCita()); // Asignar hora de la cita
            citaMedicaToCreate.setIdEstado((long) 1);
    
            return citaMedicaRepository.save(citaMedicaToCreate);
        } else {
            // Manejar la lógica en caso de citas existentes a la misma hora
            // Por ejemplo, lanzar una excepción, mostrar un mensaje de error, etc.
            return null;
        }
    }
    

    @Override
    public List<CitaMedica> getAllCitaMedica() {
        return citaMedicaRepository.findAll();
    }


    @Override
    public List<CitaMedica> getAllCitaMedicaUsuario(Long id) {
        return citaMedicaRepository.findByUsuario(id);
    }

    @Override
    public List<CitaMedica> getAllCitaMedicaUsuarioFinalizada(Long id) {
        return citaMedicaRepository.findByUsuarioFinalizada(id);
    }

    @Override
    public List<CitaMedica> getAllCitaMedicaMedico(Long id) {
        return citaMedicaRepository.findByMedico(id);
    }


    @Override
    public List<CitaMedica> getAllCitaMedicaMedicoFinalizada(Long id) {
        return citaMedicaRepository.findByMedicoFinalizada(id);
    }


    @Override
    public List<CitaMedica> getAllCitaMedicaMedicoCancelada(Long id) {
        return citaMedicaRepository.findByMedicoCancelada(id);
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

    public CitaMedica cancelarCitaMedica(CitaMedicaDTO citaMedicaDTO) {
        Optional<CitaMedica> optionalCitaMedica = citaMedicaRepository.findById(citaMedicaDTO.getIdCitaMedica());
        if (optionalCitaMedica.isPresent()) {
            CitaMedica citaMedica = optionalCitaMedica.get();
            citaMedica.setIdEstado((long) 3);
            // Actualizar los campos necesarios de la cita medica
          //  citaMedica.setFechaCita(citaMedicaDTO.getFechaCita());
            // Guardar los cambios en la base de datos
            return citaMedicaRepository.save(citaMedica);
        } else {
            return null;
        }
    }

    public CitaMedica finalizarCitaMedica(CitaMedicaDTO citaMedicaDTO) {
        Optional<CitaMedica> optionalCitaMedica = citaMedicaRepository.findById(citaMedicaDTO.getIdCitaMedica());
        if (optionalCitaMedica.isPresent()) {
            CitaMedica citaMedica = optionalCitaMedica.get();
            // Actualizar los campos necesarios de la cita medica
            citaMedica.setIdEstado((long) 2);
            //citaMedica.setFechaCita(citaMedicaDTO.getFechaCita());
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
