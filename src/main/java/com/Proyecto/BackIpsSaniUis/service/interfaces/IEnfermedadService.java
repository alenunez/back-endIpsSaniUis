package com.Proyecto.BackIpsSaniUis.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Proyecto.BackIpsSaniUis.dto.EnfermedadDTO;
import com.Proyecto.BackIpsSaniUis.model.Enfermedad;

@Service
public interface IEnfermedadService {
        
    public Enfermedad createEnfermedad(EnfermedadDTO enfermedadDTO);

    public List<Enfermedad> getAllEnfermedades();

    public Enfermedad findById(Long id);

    public Enfermedad updateEnfermedad(EnfermedadDTO enfermedadDTO);

    public Enfermedad deleteEnfermedad(Long id);
  
}
