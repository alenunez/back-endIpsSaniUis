package com.Proyecto.BackIpsSaniUis.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.BackIpsSaniUis.dto.MedicamentoDTO;
import com.Proyecto.BackIpsSaniUis.mappers.MedicamentoMapper;
import com.Proyecto.BackIpsSaniUis.model.Medicamento;
import com.Proyecto.BackIpsSaniUis.repository.MedicamentoRepository;
import com.Proyecto.BackIpsSaniUis.service.interfaces.IMedicamentoService;

@Service
public class MedicamentoServiceImpl implements IMedicamentoService {
    
    MedicamentoRepository medicamentoRepository;
    LocalDateTime today = LocalDateTime.now();

    @Override
    public Medicamento createMedicamento(MedicamentoDTO medicamentoDTO) {
        Medicamento medicamentoToCreated = MedicamentoMapper.INSTANCE.toEntity(medicamentoDTO);
        medicamentoToCreated.setFechaCreacion(today);
        return medicamentoRepository.save(medicamentoToCreated);
    }

    @Override
    public List<Medicamento> getAllMedicamentos() {
        return medicamentoRepository.findAll();
    }

    @Override
    public Medicamento findById(Long id) {
        return medicamentoRepository.findById(id).orElse(null);
    }

    public Medicamento updateMedicamento(MedicamentoDTO medicamentoDTO) {
        Optional<Medicamento> optionalMedicamento = medicamentoRepository.findById(medicamentoDTO.getIdMedicamento());
        if (optionalMedicamento.isPresent()) {
            Medicamento medicamento = optionalMedicamento.get();
            // Actualizar los campos necesarios del medicamento

            medicamento.setDescripcion(medicamentoDTO.getDescripcion());
            // Guardar los cambios en la base de datos
            return medicamentoRepository.save(medicamento);

        } else {
            return null;
        }
    }

    @Override
    public Medicamento deleteMedicamento(Long id){
        Medicamento medicamento = medicamentoRepository.findById(id).orElseThrow(null);
        if(medicamento != null){
            medicamentoRepository.delete(medicamento);
            return medicamento;
        }
        return null;
    }

    @Autowired
    public MedicamentoServiceImpl(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

}
