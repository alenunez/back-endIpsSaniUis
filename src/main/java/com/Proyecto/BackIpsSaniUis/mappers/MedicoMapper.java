package com.Proyecto.BackIpsSaniUis.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.Proyecto.BackIpsSaniUis.dto.MedicoDTO;
import com.Proyecto.BackIpsSaniUis.model.Medico;

@Mapper
public interface MedicoMapper {

    MedicoMapper INSTANCE = Mappers.getMapper(MedicoMapper.class);

    @Mapping(target = "primerNombreUsuario", source = "usuario.primerNombre")
    @Mapping(target = "contraseñaUsuario", source = "usuario.contraseña")
    @Mapping(target = "segundoNombreUsuario", source = "usuario.segundoNombre")
    @Mapping(target = "primerApellidoUsuario", source = "usuario.primerApellido")
    @Mapping(target = "segundoApellidoUsuario", source = "usuario.segundoApellido")
    @Mapping(target = "documentoIdentidadUsuario", source = "usuario.documentoIdentidad")
    @Mapping(target = "correoElectronicoUsuario", source = "usuario.correoElectronico")
    @Mapping(target = "descripcionEspecialidadMedica", source = "especialidadMedica.descripcion")
    MedicoDTO toDto(Medico medico);

    @Mapping(target = "usuario", ignore = true)
    @Mapping(target = "especialidadMedica", ignore = true)
    Medico toEntity(MedicoDTO dto);

}
