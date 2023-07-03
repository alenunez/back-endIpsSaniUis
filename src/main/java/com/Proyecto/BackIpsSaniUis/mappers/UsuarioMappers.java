package com.Proyecto.BackIpsSaniUis.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.Proyecto.BackIpsSaniUis.dto.UsuarioDTO;
import com.Proyecto.BackIpsSaniUis.model.Usuario;

@Mapper
public interface UsuarioMappers {

    UsuarioMappers INSTANCE = Mappers.getMapper(UsuarioMappers.class);

    @Mapping(target = "contrasena", ignore = true)
    @Mapping(target = "descripcionRol", source = "rol.descripcion")
    UsuarioDTO usuarioToUsuarioDTO(Usuario usuario);

    @Mapping(target = "contrasena", source = "contrasena") // Si los nombres son diferentes
    Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO);
}

