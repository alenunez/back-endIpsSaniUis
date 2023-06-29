package com.Proyecto.BackIpsSaniUis.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.Proyecto.BackIpsSaniUis.dto.EnfermedadDTO;
import com.Proyecto.BackIpsSaniUis.model.Enfermedad;

@Mapper
public interface EnfermedadMapper {

    EnfermedadMapper INSTANCE = Mappers.getMapper(EnfermedadMapper.class);

    @Mapping(source = "idEnfermedad", target = "idEnfermedad")
    EnfermedadDTO toDto(Enfermedad entidad);

    @Mapping(source = "idEnfermedad", target = "idEnfermedad")
    Enfermedad toEntity(EnfermedadDTO dto);
}
