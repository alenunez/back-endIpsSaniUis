package com.Proyecto.BackIpsSaniUis.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.Proyecto.BackIpsSaniUis.dto.HistoriaClinicaDTO;
import com.Proyecto.BackIpsSaniUis.model.HistoriaClinica;

@Mapper
public interface HistoriaClinicaMapper {

    HistoriaClinicaMapper INSTANCE = Mappers.getMapper(HistoriaClinicaMapper.class);

    @Mapping(target = "primerNombreUsuario", source = "usuario.primerNombre")
    @Mapping(target = "contraseñaUsuario", source = "usuario.contraseña")
    @Mapping(target = "segundoNombreUsuario", source = "usuario.segundoNombre")
    @Mapping(target = "primerApellidoUsuario", source = "usuario.primerApellido")
    @Mapping(target = "segundoApellidoUsuario", source = "usuario.segundoApellido")
    @Mapping(target = "documentoIdentidadUsuario", source = "usuario.documentoIdentidad")
    @Mapping(target = "correoElectronicoUsuario", source = "usuario.correoElectronico")
    HistoriaClinicaDTO toDto(HistoriaClinica historiaClinica);

    @Mapping(target = "usuario", ignore = true)
    HistoriaClinica toEntity(HistoriaClinicaDTO historiaClinicaDTO);

}
