package com.Proyecto.BackIpsSaniUis.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Proyecto.BackIpsSaniUis.dto.MarcaMedicamentoDTO;
import com.Proyecto.BackIpsSaniUis.model.MarcaMedicamento;

@Service
public interface IMarcaMedicamentoService {
    
    public MarcaMedicamento createMarcaMedicamento(MarcaMedicamentoDTO marcaMedicamentoDTO);

    public List<MarcaMedicamento> getAllMarcaMedicamentos();

    public MarcaMedicamento findById(Long id);

    public MarcaMedicamento updateMarcaMedicamento(MarcaMedicamentoDTO marcaMedicamentoDTO);

    public MarcaMedicamento deleteMarcaMedicamento(Long id);
  
}
