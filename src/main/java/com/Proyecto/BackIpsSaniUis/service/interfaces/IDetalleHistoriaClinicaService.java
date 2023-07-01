package com.Proyecto.BackIpsSaniUis.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Proyecto.BackIpsSaniUis.dto.DetalleHistoriaClinicaDTO;
import com.Proyecto.BackIpsSaniUis.model.DetalleHistoriaClinica;

@Service
public interface IDetalleHistoriaClinicaService {
                    
    public DetalleHistoriaClinica createDetalleHistoriaClinica(DetalleHistoriaClinicaDTO detalleHistoriaClinicaDTO);

    public List<DetalleHistoriaClinica> getAllDetalleHistoriaClinica();

    public DetalleHistoriaClinica findById(Long id);

    public DetalleHistoriaClinica deleteDetalleHistoriaClinica(Long id);
    
}
