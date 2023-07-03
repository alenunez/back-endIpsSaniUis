package com.Proyecto.BackIpsSaniUis.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.BackIpsSaniUis.dto.EspecialidadMedicaDTO;
import com.Proyecto.BackIpsSaniUis.mappers.EspecialidadMedicaMapper;
import com.Proyecto.BackIpsSaniUis.model.EspecialidadMedica;
import com.Proyecto.BackIpsSaniUis.repository.EspecialidadMedicaRepository;
import com.Proyecto.BackIpsSaniUis.service.interfaces.IEspecialidadMedicaService;

@Service
public class EspecialidadMedicaServiceImpl implements IEspecialidadMedicaService{
            
    EspecialidadMedicaRepository especialidadMedicaRepository;

    LocalDateTime today = LocalDateTime.now();

    @Override
    public EspecialidadMedica createEspecialidadMedica(EspecialidadMedicaDTO especialidadMedicaDTO) {
        EspecialidadMedica especialidadMedicaToCreated = EspecialidadMedicaMapper.INSTANCE.toEntity(especialidadMedicaDTO);
        especialidadMedicaToCreated.setFechaCreacion(today);
        return especialidadMedicaRepository.save(especialidadMedicaToCreated);
    }

    @Override
    public List<EspecialidadMedica> getAllEspecialidadMedica() {
        return especialidadMedicaRepository.findAll();
    }

    @Override
    public EspecialidadMedica findById(Long id) {
        return especialidadMedicaRepository.findById(id).orElse(null);
    }



    public EspecialidadMedica updateEspecialidadMedica(EspecialidadMedicaDTO especialidadMedicaDTO) {
        Optional<EspecialidadMedica> optionalEspecialidadMedica = especialidadMedicaRepository.findById(especialidadMedicaDTO.getIdEspecialidadMedica());
        if (optionalEspecialidadMedica.isPresent()) {
            EspecialidadMedica especialidadMedica = optionalEspecialidadMedica.get();
            // Actualizar los campos necesarios del usuario

            especialidadMedica.setDescripcion(especialidadMedicaDTO.getDescripcion());
            // Guardar los cambios en la base de datos
            return especialidadMedicaRepository.save(especialidadMedica);

        } else {
            return null;
        }
    }

    @Override
    public EspecialidadMedica deleteEspecialidadMedica(Long id){
        EspecialidadMedica especialidadMedica = especialidadMedicaRepository.findById(id).orElseThrow(null);
        if(especialidadMedica != null){
            especialidadMedicaRepository.delete(especialidadMedica);
            return especialidadMedica;
        }
        return null;
    }

    @Autowired
    public EspecialidadMedicaServiceImpl(EspecialidadMedicaRepository especialidadMedicaRepository) {
        this.especialidadMedicaRepository = especialidadMedicaRepository;
    }

   
}
