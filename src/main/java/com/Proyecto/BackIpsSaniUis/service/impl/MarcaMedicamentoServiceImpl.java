package com.Proyecto.BackIpsSaniUis.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.BackIpsSaniUis.dto.MarcaMedicamentoDTO;
import com.Proyecto.BackIpsSaniUis.mappers.MarcaMedicamentoMapper;
import com.Proyecto.BackIpsSaniUis.model.MarcaMedicamento;
import com.Proyecto.BackIpsSaniUis.repository.MarcaMedicamentoRepository;
import com.Proyecto.BackIpsSaniUis.service.interfaces.IMarcaMedicamentoService;

@Service
public class MarcaMedicamentoServiceImpl implements IMarcaMedicamentoService{
    
    MarcaMedicamentoRepository marcaMedicamentoRepository;

    LocalDateTime today = LocalDateTime.now();

    @Override
    public MarcaMedicamento createMarcaMedicamento(MarcaMedicamentoDTO marcaMedicamentoDTO) {
        MarcaMedicamento marcaMedicamentoToCreated = MarcaMedicamentoMapper.INSTANCE.toEntity(marcaMedicamentoDTO);
        marcaMedicamentoToCreated.setFechaCreacion(today);
        return marcaMedicamentoRepository.save(marcaMedicamentoToCreated);
    }

    @Override
    public List<MarcaMedicamento> getAllMarcaMedicamentos() {
        return marcaMedicamentoRepository.findAll();
    }

    @Override
    public MarcaMedicamento findById(Long id) {
        return marcaMedicamentoRepository.findById(id).orElse(null);
    }



    public MarcaMedicamento updateMarcaMedicamento(MarcaMedicamentoDTO marcaMedicamentoDTO) {
        Optional<MarcaMedicamento> optionalMarcaMedicamento = marcaMedicamentoRepository.findById(marcaMedicamentoDTO.getIdMarcaMedicamento());
        if (optionalMarcaMedicamento.isPresent()) {
            MarcaMedicamento marcaMedicamento = optionalMarcaMedicamento.get();
            // Actualizar los campos necesarios del usuario

            marcaMedicamento.setDescripcion(marcaMedicamentoDTO.getDescripcion());
            // Guardar los cambios en la base de datos
            return marcaMedicamentoRepository.save(marcaMedicamento);

        } else {
            return null;
        }
    }

    @Override
    public MarcaMedicamento deleteMarcaMedicamento(Long id){
        MarcaMedicamento marcaMedicamento = marcaMedicamentoRepository.findById(id).orElseThrow(null);
        if(marcaMedicamento != null){
            marcaMedicamentoRepository.delete(marcaMedicamento);
            return marcaMedicamento;
        }
        return null;
    }

    @Autowired
    public MarcaMedicamentoServiceImpl(MarcaMedicamentoRepository marcaMedicamentoRepository) {
        this.marcaMedicamentoRepository = marcaMedicamentoRepository;
    }

    
}
