package com.Proyecto.BackIpsSaniUis.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Proyecto.BackIpsSaniUis.dto.HistoriaClinicaDTO;
import com.Proyecto.BackIpsSaniUis.model.HistoriaClinica;

@Service
public interface IHistoriaClinicaService {
        
    public HistoriaClinica createHistoriaClinica(HistoriaClinicaDTO historiaClinicaDTO);

    public List<HistoriaClinica> getAllHistoriaClinica();

    public HistoriaClinica findById(Long id);

    public HistoriaClinica deleteHistoriaClinica(Long id);

}
