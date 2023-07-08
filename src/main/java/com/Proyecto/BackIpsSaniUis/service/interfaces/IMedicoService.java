package com.Proyecto.BackIpsSaniUis.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Proyecto.BackIpsSaniUis.dto.MedicoDTO;
import com.Proyecto.BackIpsSaniUis.model.Medico;

@Service
public interface IMedicoService {
            
    public Medico createMedico(MedicoDTO medicoDTO);

    public List<Medico> getAllMedicos();

    public Medico findById(Long id);

    public List<Medico> findByEspecialidad(Long id);


    public Medico deleteMedico(Long id);

}
