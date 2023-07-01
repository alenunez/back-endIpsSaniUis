package com.Proyecto.BackIpsSaniUis.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Proyecto.BackIpsSaniUis.dto.DiagnosticoDTO;
import com.Proyecto.BackIpsSaniUis.model.Diagnostico;

@Service
public interface IDiagnosticoService {
                
    public Diagnostico createDiagnostico(DiagnosticoDTO diagnosticoDTO);

    public List<Diagnostico> getAllDiagnosticos();

    public Diagnostico findById(Long id);

    public Diagnostico updateDiagnostico(DiagnosticoDTO diagnosticoDTO);

    public Diagnostico deleteDiagnostico(Long id);
    
}
