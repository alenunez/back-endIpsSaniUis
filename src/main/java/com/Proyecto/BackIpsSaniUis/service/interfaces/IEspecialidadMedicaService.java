package com.Proyecto.BackIpsSaniUis.service.interfaces;

import java.util.List;

import com.Proyecto.BackIpsSaniUis.dto.EspecialidadMedicaDTO;
import com.Proyecto.BackIpsSaniUis.model.EspecialidadMedica;

public interface IEspecialidadMedicaService {
            
    public EspecialidadMedica createEspecialidadMedica(EspecialidadMedicaDTO especialidadMedicaDTO);

    public List<EspecialidadMedica> getAllEspecialidadMedica();

    public EspecialidadMedica findById(Long id);

    public EspecialidadMedica updateEspecialidadMedica(EspecialidadMedicaDTO especialidadMedicaDTO);

    public EspecialidadMedica deleteEspecialidadMedica(Long id);
  
}
