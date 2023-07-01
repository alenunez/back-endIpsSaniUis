package com.Proyecto.BackIpsSaniUis.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.BackIpsSaniUis.dto.HistoriaClinicaDTO;
import com.Proyecto.BackIpsSaniUis.mappers.HistoriaClinicaMapper;
import com.Proyecto.BackIpsSaniUis.model.HistoriaClinica;
import com.Proyecto.BackIpsSaniUis.repository.HistoriaClinicaRepository;
import com.Proyecto.BackIpsSaniUis.service.interfaces.IHistoriaClinicaService;

@Service
public class HistoriaClinicaServiceImpl implements IHistoriaClinicaService {
        
    HistoriaClinicaRepository historiaClinicaRepository;
    LocalDateTime today = LocalDateTime.now();

    @Override
    public HistoriaClinica createHistoriaClinica(HistoriaClinicaDTO historiaClinicaDTO) {
        HistoriaClinica historiaClinicaToCreated = HistoriaClinicaMapper.INSTANCE.toEntity(historiaClinicaDTO);
        historiaClinicaToCreated.setFechaCreacion(today);
        return historiaClinicaRepository.save(historiaClinicaToCreated);
    }

    @Override
    public List<HistoriaClinica> getAllHistoriaClinica() {
        return historiaClinicaRepository.findAll();
    }

    @Override
    public HistoriaClinica findById(Long id) {
        return historiaClinicaRepository.findById(id).orElse(null);
    }

    @Override
    public HistoriaClinica deleteHistoriaClinica(Long id){
        HistoriaClinica historiaClinica = historiaClinicaRepository.findById(id).orElseThrow(null);
        if(historiaClinica != null){
            historiaClinicaRepository.delete(historiaClinica);
            return historiaClinica;
        }
        return null;
    }

    @Autowired
    public HistoriaClinicaServiceImpl(HistoriaClinicaRepository historiaClinicaRepository) {
        this.historiaClinicaRepository = historiaClinicaRepository;
    }

}
