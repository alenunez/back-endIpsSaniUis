package com.Proyecto.BackIpsSaniUis.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.Proyecto.BackIpsSaniUis.dto.DiagnosticoDTO;
import com.Proyecto.BackIpsSaniUis.model.Diagnostico;

@Mapper
public interface DiagnosticoMapper {

    DiagnosticoMapper INSTANCE = Mappers.getMapper(DiagnosticoMapper.class);

    @Mapping(source = "citaMedica.fechaCita", target = "fechaCitaCitaMedica")
    @Mapping(source = "enfermedad.descripcion", target = "descripcionEnfermedad")
    DiagnosticoDTO toDto(Diagnostico diagnostico);

    @Mapping(target = "citaMedica", ignore = true)
    @Mapping(target = "enfermedad", ignore = true)
    Diagnostico toEntity(DiagnosticoDTO diagnosticoDTO);
}
