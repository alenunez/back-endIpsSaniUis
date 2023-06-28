package com.Proyecto.BackIpsSaniUis.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.Proyecto.BackIpsSaniUis.dto.MarcaMedicamentoDTO;
import com.Proyecto.BackIpsSaniUis.model.MarcaMedicamento;

@Mapper
public interface MarcaMedicamentoMapper {

    MarcaMedicamentoMapper INSTANCE = Mappers.getMapper(MarcaMedicamentoMapper.class);

    @Mapping(source = "idMarcaMedicamento", target = "idMarcaMedicamento")
    MarcaMedicamentoDTO toDto(MarcaMedicamento entidad);

    @Mapping(source = "idMarcaMedicamento", target = "idMarcaMedicamento")
    MarcaMedicamento toEntity(MarcaMedicamentoDTO dto);

}