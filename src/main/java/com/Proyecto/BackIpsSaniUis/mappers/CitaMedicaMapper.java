package com.Proyecto.BackIpsSaniUis.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.Proyecto.BackIpsSaniUis.dto.CitaMedicaDTO;
import com.Proyecto.BackIpsSaniUis.model.CitaMedica;

@Mapper
public interface CitaMedicaMapper {

    CitaMedicaMapper INSTANCE = Mappers.getMapper(CitaMedicaMapper.class);

    @Mapping(target = "primerNombreUsuario", source = "usuario.primerNombre")
    @Mapping(target = "primerApellidoUsuario", source = "usuario.primerApellido")
    @Mapping(target = "primerNombreMedico", source = "medico.usuario.primerNombre")
    @Mapping(target = "primerApellidoMedico", source = "medico.usuario.primerApellido")
    CitaMedicaDTO toDto(CitaMedica citaMedica);

    @Mapping(target = "usuario", ignore = true)
    @Mapping(target = "medico", ignore = true)
    CitaMedica toEntity(CitaMedicaDTO dto);

}
