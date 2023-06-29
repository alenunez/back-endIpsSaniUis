package com.Proyecto.BackIpsSaniUis.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.BackIpsSaniUis.dto.TipoMedicamentoDTO;
import com.Proyecto.BackIpsSaniUis.mappers.TipoMedicamentoMapper;
import com.Proyecto.BackIpsSaniUis.model.TipoMedicamento;
import com.Proyecto.BackIpsSaniUis.repository.TipoMedicamentoRepository;
import com.Proyecto.BackIpsSaniUis.service.interfaces.ITipoMedicamentoService;

@Service
public class TipoMedicamentoServiceImpl implements ITipoMedicamentoService {
        
    TipoMedicamentoRepository tipoMedicamentoRepository;

    LocalDateTime today = LocalDateTime.now();

    @Override
    public TipoMedicamento createTipoMedicamento(TipoMedicamentoDTO tipoMedicamentoDTO) {
        TipoMedicamento tipoMedicamentoToCreated = TipoMedicamentoMapper.INSTANCE.toEntity(tipoMedicamentoDTO);
        tipoMedicamentoToCreated.setFechaCreacion(today);
        return tipoMedicamentoRepository.save(tipoMedicamentoToCreated);
    }

    @Override
    public List<TipoMedicamento> getAllTipoMedicamentos() {
        return tipoMedicamentoRepository.findAll();
    }

    @Override
    public TipoMedicamento findById(Long id) {
        return tipoMedicamentoRepository.findById(id).orElse(null);
    }



    public TipoMedicamento updateTipoMedicamento(TipoMedicamentoDTO tipoMedicamentoDTO) {
        Optional<TipoMedicamento> optionalTipoMedicamento = tipoMedicamentoRepository.findById(tipoMedicamentoDTO.getIdTipoMedicamento());
        if (optionalTipoMedicamento.isPresent()) {
            TipoMedicamento tipoMedicamento = optionalTipoMedicamento.get();
            // Actualizar los campos necesarios del usuario

            tipoMedicamento.setDescripcion(tipoMedicamentoDTO.getDescripcion());
            // Guardar los cambios en la base de datos
            return tipoMedicamentoRepository.save(tipoMedicamento);

        } else {
            return null;
        }
    }

    @Override
    public TipoMedicamento deleteTipoMedicamento(Long id){
        TipoMedicamento tipoMedicamento = tipoMedicamentoRepository.findById(id).orElseThrow(null);
        if(tipoMedicamento != null){
            tipoMedicamentoRepository.delete(tipoMedicamento);
            return tipoMedicamento;
        }
        return null;
    }

    @Autowired
    public TipoMedicamentoServiceImpl(TipoMedicamentoRepository tipoMedicamentoRepository) {
        this.tipoMedicamentoRepository = tipoMedicamentoRepository;
    }

   
}
