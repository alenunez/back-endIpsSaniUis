package com.Proyecto.BackIpsSaniUis.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Proyecto.BackIpsSaniUis.dto.CitaMedicaDTO;
import com.Proyecto.BackIpsSaniUis.model.CitaMedica;

@Service
public interface ICitaMedicaService {
                
    public CitaMedica createCitaMedica(CitaMedicaDTO citaMedicaDTO);

    public List<CitaMedica> getAllCitaMedica();

    public List<CitaMedica> getAllCitaMedicaUsuario(Long id);


    public CitaMedica findById(Long id);

    public CitaMedica updateCitaMedica(CitaMedicaDTO citaMedicaDTO);

    public CitaMedica deleteCitaMedica(Long id);

}
