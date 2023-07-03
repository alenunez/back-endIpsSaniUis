package com.Proyecto.BackIpsSaniUis.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Proyecto.BackIpsSaniUis.dto.MedicamentoDTO;
import com.Proyecto.BackIpsSaniUis.model.Medicamento;

@Service
public interface IMedicamentoService {
    
    public Medicamento createMedicamento(MedicamentoDTO medicamentoDTO);

    public List<Medicamento> getAllMedicamentos();

    public Medicamento findById(Long id);
    
    public Medicamento updateMedicamento(MedicamentoDTO medicamentoDTO);

    public Medicamento deleteMedicamento(Long id);

}
