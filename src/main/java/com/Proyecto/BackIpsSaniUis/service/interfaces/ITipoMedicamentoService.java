package com.Proyecto.BackIpsSaniUis.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Proyecto.BackIpsSaniUis.dto.TipoMedicamentoDTO;
import com.Proyecto.BackIpsSaniUis.model.TipoMedicamento;

@Service
public interface ITipoMedicamentoService {
        
    public TipoMedicamento createTipoMedicamento(TipoMedicamentoDTO tipoMedicamentoDTO);

    public List<TipoMedicamento> getAllTipoMedicamentos();

    public TipoMedicamento findById(Long id);

    public TipoMedicamento updateTipoMedicamento(TipoMedicamentoDTO tipoMedicamentoDTO);

    public TipoMedicamento deleteTipoMedicamento(Long id);
  
}
