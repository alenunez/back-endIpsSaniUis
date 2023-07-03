package com.Proyecto.BackIpsSaniUis.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.Proyecto.BackIpsSaniUis.dto.DetalleTratamientoDTO;
import com.Proyecto.BackIpsSaniUis.model.DetalleTratamiento;

@Mapper
public interface DetalleTratamientoMapper {
    
    DetalleTratamientoMapper INSTANCE = Mappers.getMapper(DetalleTratamientoMapper.class);

    DetalleTratamientoDTO toDto(DetalleTratamiento detalleTratamiento);

    @Mapping(target = "tratamiento", ignore = true)
    @Mapping(target = "medicamento", ignore = true)
    DetalleTratamiento toEntity(DetalleTratamientoDTO detalleTratamientoDTO);
}
