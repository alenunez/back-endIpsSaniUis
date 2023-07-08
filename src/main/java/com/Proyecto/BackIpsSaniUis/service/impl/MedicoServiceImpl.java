package com.Proyecto.BackIpsSaniUis.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.BackIpsSaniUis.dto.MedicoDTO;
import com.Proyecto.BackIpsSaniUis.mappers.MedicoMapper;
import com.Proyecto.BackIpsSaniUis.model.Medico;
import com.Proyecto.BackIpsSaniUis.repository.MedicoRepository;
import com.Proyecto.BackIpsSaniUis.service.interfaces.IMedicoService;

@Service
public class MedicoServiceImpl implements IMedicoService {
            
    MedicoRepository medicoRepository;
    LocalDateTime today = LocalDateTime.now();

    @Override
    public Medico createMedico(MedicoDTO medicoDTO) {
        Medico medicoToCreated = MedicoMapper.INSTANCE.toEntity(medicoDTO);
        medicoToCreated.setFechaCreacion(today);
        return medicoRepository.save(medicoToCreated);
    }

    @Override
    public List<Medico> getAllMedicos() {
        return medicoRepository.findAll();
    }

    @Override
    public Medico findById(Long id) {
        return medicoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Medico>  findByEspecialidad(Long idEspecialidad) {
        return medicoRepository.findByEspecialidad(idEspecialidad);
    }

    @Override
    public Medico deleteMedico(Long id){
        Medico medico = medicoRepository.findById(id).orElseThrow(null);
        if(medico!= null){
            medicoRepository.delete(medico);
            return medico;
        }
        return null;
    }

    @Autowired
    public MedicoServiceImpl(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

}
