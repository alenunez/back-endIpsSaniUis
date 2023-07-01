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
    @Mapping(target = "contraseñaUsuario", source = "usuario.contraseña")
    @Mapping(target = "segundoNombreUsuario", source = "usuario.segundoNombre")
    @Mapping(target = "primerApellidoUsuario", source = "usuario.primerApellido")
    @Mapping(target = "segundoApellidoUsuario", source = "usuario.segundoApellido")
    @Mapping(target = "documentoIdentidadUsuario", source = "usuario.documentoIdentidad")
    @Mapping(target = "correoElectronicoUsuario", source = "usuario.correoElectronico")
    CitaMedicaDTO toDto(CitaMedica citaMedica);

    @Mapping(target = "usuario", ignore = true)
    @Mapping(target = "medico", ignore = true)
    CitaMedica toEntity(CitaMedicaDTO dto);

}
