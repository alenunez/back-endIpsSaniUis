package com.Proyecto.BackIpsSaniUis.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.BackIpsSaniUis.dto.DetalleTratamientoDTO;
import com.Proyecto.BackIpsSaniUis.mappers.DetalleTratamientoMapper;
import com.Proyecto.BackIpsSaniUis.model.DetalleTratamiento;
import com.Proyecto.BackIpsSaniUis.repository.DetalleTratamientoRepository;
import com.Proyecto.BackIpsSaniUis.service.interfaces.IDetalleTratamientoService;

@Service
public class DetalleTratamientoServiceImpl implements IDetalleTratamientoService {
                
    DetalleTratamientoRepository detalleTratamientoRepository;
    LocalDateTime today = LocalDateTime.now();

    @Override
    public DetalleTratamiento createDetalleTratamiento(DetalleTratamientoDTO detalleTratamientoDTO) {
        DetalleTratamiento detalleTratamientoToCreated = DetalleTratamientoMapper.INSTANCE.toEntity(detalleTratamientoDTO);
        detalleTratamientoToCreated.setFechaCreacion(today);
        return detalleTratamientoRepository.save(detalleTratamientoToCreated);
    }

    @Override
    public List<DetalleTratamiento> getAllDetalleTratamiento() {
        return detalleTratamientoRepository.findAll();
    }

    @Override
    public DetalleTratamiento findById(Long id) {
        return detalleTratamientoRepository.findById(id).orElse(null);
    }

    @Override
    public DetalleTratamiento deleteDetalleTratamiento(Long id){
        DetalleTratamiento detalleTratamiento = detalleTratamientoRepository.findById(id).orElseThrow(null);
        if(detalleTratamiento != null){
            detalleTratamientoRepository.delete(detalleTratamiento);
            return detalleTratamiento;
        }
        return null;
    }

    @Autowired
    public DetalleTratamientoServiceImpl(DetalleTratamientoRepository detalleTratamientoRepository) {
        this.detalleTratamientoRepository = detalleTratamientoRepository;
    }

}
