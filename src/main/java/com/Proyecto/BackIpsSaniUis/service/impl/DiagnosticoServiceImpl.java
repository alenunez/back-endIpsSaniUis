package com.Proyecto.BackIpsSaniUis.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.BackIpsSaniUis.dto.DiagnosticoDTO;
import com.Proyecto.BackIpsSaniUis.mappers.DiagnosticoMapper;
import com.Proyecto.BackIpsSaniUis.model.Diagnostico;
import com.Proyecto.BackIpsSaniUis.repository.DiagnosticoRepository;
import com.Proyecto.BackIpsSaniUis.service.interfaces.IDiagnosticoService;

@Service
public class DiagnosticoServiceImpl implements IDiagnosticoService {
            
    DiagnosticoRepository diagnosticoRepository;
    LocalDateTime today = LocalDateTime.now();

    @Override
    public Diagnostico createDiagnostico(DiagnosticoDTO diagnosticoDTO) {
        Diagnostico diagnosticoToCreated = DiagnosticoMapper.INSTANCE.toEntity(diagnosticoDTO);
        diagnosticoToCreated.setFechaCreacion(today);
        return diagnosticoRepository.save(diagnosticoToCreated);
    }

    @Override
    public List<Diagnostico> getAllDiagnosticos() {
        return diagnosticoRepository.findAll();
    }

    @Override
    public Diagnostico findById(Long id) {
        return diagnosticoRepository.findById(id).orElse(null);
    }

    @Override
    public Diagnostico findByCita(Long id) {
        return diagnosticoRepository.findByCita(id);
    }

    public Diagnostico updateDiagnostico(DiagnosticoDTO diagnosticoDTO) {
        Optional<Diagnostico> optionalDiagnostico = diagnosticoRepository.findById(diagnosticoDTO.getIdDiagnostico());
        if (optionalDiagnostico.isPresent()) {
            Diagnostico diagnostico = optionalDiagnostico.get();
            // Actualizar los campos necesarios del diagnostico

            diagnostico.setComentario(diagnosticoDTO.getComentario());
            // Guardar los cambios en la base de datos
            return diagnosticoRepository.save(diagnostico);

        } else {
            return null;
        }
    }

    @Override
    public Diagnostico deleteDiagnostico(Long id){
        Diagnostico diagnostico = diagnosticoRepository.findById(id).orElseThrow(null);
        if(diagnostico != null){
            diagnosticoRepository.delete(diagnostico);
            return diagnostico;
        }
        return null;
    }

    @Autowired
    public DiagnosticoServiceImpl(DiagnosticoRepository diagnosticoRepository) {
        this.diagnosticoRepository = diagnosticoRepository;
    }

}
