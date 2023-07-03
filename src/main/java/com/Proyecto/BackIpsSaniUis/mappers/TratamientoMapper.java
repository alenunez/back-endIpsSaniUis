package com.Proyecto.BackIpsSaniUis.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.Proyecto.BackIpsSaniUis.dto.TratamientoDTO;
import com.Proyecto.BackIpsSaniUis.model.Tratamiento;

@Mapper
public interface TratamientoMapper {

    TratamientoMapper INSTANCE = Mappers.getMapper(TratamientoMapper.class);

    @Mapping(source = "citaMedica.fechaCita", target = "fechaCitaCitaMedica")
    TratamientoDTO toDto(Tratamiento tratamiento);

    @Mapping(target = "citaMedica", ignore = true)
    Tratamiento toEntity(TratamientoDTO tratamientoDTO);
}
