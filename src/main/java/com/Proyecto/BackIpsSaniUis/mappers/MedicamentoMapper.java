package com.Proyecto.BackIpsSaniUis.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.Proyecto.BackIpsSaniUis.dto.MedicamentoDTO;
import com.Proyecto.BackIpsSaniUis.model.Medicamento;

@Mapper
public interface MedicamentoMapper {

    MedicamentoMapper INSTANCE = Mappers.getMapper(MedicamentoMapper.class);

    @Mapping(target = "descripcionMarcaMedicamento", source = "marcaMedicamento.descripcion")
    @Mapping(target = "descripcionTipoMedicamento", source = "tipoMedicamento.descripcion")
    MedicamentoDTO toDto(Medicamento medicamento);

    @Mapping(target = "marcaMedicamento", ignore = true)
    @Mapping(target = "tipoMedicamento", ignore = true)
    Medicamento toEntity(MedicamentoDTO dto);

}
