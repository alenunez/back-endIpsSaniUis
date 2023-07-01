package com.Proyecto.BackIpsSaniUis.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.BackIpsSaniUis.dto.DetalleHistoriaClinicaDTO;
import com.Proyecto.BackIpsSaniUis.mappers.DetalleHistoriaClinicaMapper;
import com.Proyecto.BackIpsSaniUis.model.DetalleHistoriaClinica;
import com.Proyecto.BackIpsSaniUis.repository.DetalleHistoriaClinicaRepository;
import com.Proyecto.BackIpsSaniUis.service.interfaces.IDetalleHistoriaClinicaService;

@Service
public class DetalleHistoriaClinicaServiceImpl implements IDetalleHistoriaClinicaService {
                
    DetalleHistoriaClinicaRepository detalleHistoriaClinicaRepository;
    LocalDateTime today = LocalDateTime.now();

    @Override
    public DetalleHistoriaClinica createDetalleHistoriaClinica(DetalleHistoriaClinicaDTO detalleHistoriaClinicaDTO) {
        DetalleHistoriaClinica detalleHistoriaClinicaToCreated = DetalleHistoriaClinicaMapper.INSTANCE.toEntity(detalleHistoriaClinicaDTO);
        detalleHistoriaClinicaToCreated.setFechaCreacion(today);
        return detalleHistoriaClinicaRepository.save(detalleHistoriaClinicaToCreated);
    }

    @Override
    public List<DetalleHistoriaClinica> getAllDetalleHistoriaClinica() {
        return detalleHistoriaClinicaRepository.findAll();
    }

    @Override
    public DetalleHistoriaClinica findById(Long id) {
        return detalleHistoriaClinicaRepository.findById(id).orElse(null);
    }

    @Override
    public DetalleHistoriaClinica deleteDetalleHistoriaClinica(Long id){
        DetalleHistoriaClinica detalleHistoriaClinica = detalleHistoriaClinicaRepository.findById(id).orElseThrow(null);
        if(detalleHistoriaClinica != null){
            detalleHistoriaClinicaRepository.delete(detalleHistoriaClinica);
            return detalleHistoriaClinica;
        }
        return null;
    }

    @Autowired
    public DetalleHistoriaClinicaServiceImpl(DetalleHistoriaClinicaRepository detalleHistoriaClinicaRepository) {
        this.detalleHistoriaClinicaRepository = detalleHistoriaClinicaRepository;
    }

}
