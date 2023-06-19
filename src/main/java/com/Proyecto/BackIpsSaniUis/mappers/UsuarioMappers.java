package com.Proyecto.BackIpsSaniUis.mappers;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.Proyecto.BackIpsSaniUis.dto.UsuarioDTO;
import com.Proyecto.BackIpsSaniUis.model.Usuario;

@Mapper
public interface UsuarioMappers {

    UsuarioMappers INSTANCE = Mappers.getMapper(UsuarioMappers.class);

    @Mapping(target = "contraseña", source = "contraseña") // Si los nombres son diferentes
    UsuarioDTO usuarioToUsuarioDTO(Usuario usuario);

    @Mapping(target = "contraseña", source = "contraseña") // Si los nombres son diferentes
    Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO);
}
