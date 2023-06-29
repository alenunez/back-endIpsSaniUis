package com.Proyecto.BackIpsSaniUis.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.Proyecto.BackIpsSaniUis.dto.TipoMedicamentoDTO;
import com.Proyecto.BackIpsSaniUis.model.TipoMedicamento;

@Mapper
public interface TipoMedicamentoMapper {

    TipoMedicamentoMapper INSTANCE = Mappers.getMapper(TipoMedicamentoMapper.class);

    @Mapping(source = "idTipoMedicamento", target = "idTipoMedicamento")
    TipoMedicamentoDTO toDto(TipoMedicamento tipoMedicamento);

    @Mapping(source = "idTipoMedicamento", target = "idTipoMedicamento")
    TipoMedicamento toEntity(TipoMedicamentoDTO tipoMedicamentoDTO);
}
