package com.Proyecto.BackIpsSaniUis.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Proyecto.BackIpsSaniUis.dto.TratamientoDTO;
import com.Proyecto.BackIpsSaniUis.model.Tratamiento;

@Service
public interface ITratamientoService {
            
    public Tratamiento createTratamiento(TratamientoDTO tratamientoDTO);

    public List<Tratamiento> getAllTratamientos();

    public Tratamiento findById(Long id);

    public Tratamiento updateTratamiento(TratamientoDTO tratamientoDTO);

    public Tratamiento deleteTratamiento(Long id);
    
}
