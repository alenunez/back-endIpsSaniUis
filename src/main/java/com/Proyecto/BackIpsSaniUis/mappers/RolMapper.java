package com.Proyecto.BackIpsSaniUis.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.Proyecto.BackIpsSaniUis.dto.RolDTO;
import com.Proyecto.BackIpsSaniUis.model.Rol;

@Mapper
public interface RolMapper {

    RolMapper INSTANCE = Mappers.getMapper(RolMapper.class);

    @Mapping(source = "idRol", target = "idRol")
    RolDTO rolToRolDTO(Rol rol);

    @Mapping(source = "idRol", target = "idRol")
    Rol rolDTOToRol(RolDTO rolDTO);
}
