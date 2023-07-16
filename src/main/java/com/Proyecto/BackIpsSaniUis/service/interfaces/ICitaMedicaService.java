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

    public List<CitaMedica> getAllCitaMedicaUsuarioFinalizada(Long id);


    public List<CitaMedica> getAllCitaMedicaMedico(Long id);

    public List<CitaMedica> getAllCitaMedicaMedicoFinalizada(Long id);

    public List<CitaMedica> getAllCitaMedicaMedicoCancelada(Long id);



    public CitaMedica findById(Long id);

    public CitaMedica updateCitaMedica(CitaMedicaDTO citaMedicaDTO);

    public CitaMedica cancelarCitaMedica(CitaMedicaDTO citaMedicaDTO);

    public CitaMedica finalizarCitaMedica(CitaMedicaDTO citaMedicaDTO);



    public CitaMedica deleteCitaMedica(Long id);

}
