package com.Proyecto.BackIpsSaniUis.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Proyecto.BackIpsSaniUis.dto.DetalleTratamientoDTO;
import com.Proyecto.BackIpsSaniUis.model.DetalleTratamiento;

@Service
public interface IDetalleTratamientoService {
                    
    public DetalleTratamiento createDetalleTratamiento(DetalleTratamientoDTO detalleTratamientoDTO);

    public List<DetalleTratamiento> getAllDetalleTratamiento();

    public DetalleTratamiento findById(Long id);

    public DetalleTratamiento deleteDetalleTratamiento(Long id);
    
}
