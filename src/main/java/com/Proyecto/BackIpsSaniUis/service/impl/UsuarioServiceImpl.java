package com.Proyecto.BackIpsSaniUis.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.Proyecto.BackIpsSaniUis.dto.UsuarioDTO;
import com.Proyecto.BackIpsSaniUis.mappers.UsuarioMappers;
import com.Proyecto.BackIpsSaniUis.model.Usuario;
import com.Proyecto.BackIpsSaniUis.repository.UsuarioRepository;
import com.Proyecto.BackIpsSaniUis.service.interfaces.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    UsuarioRepository usuarioRepository;
    LocalDateTime today = LocalDateTime.now();

    @Override
    public Usuario createUsuario(UsuarioDTO usuarioDTO) {
        Usuario usarioToCreated = UsuarioMappers.INSTANCE.usuarioDTOToUsuario(usuarioDTO);
        usarioToCreated.setFechaCreacion(today);
        return usuarioRepository.save(usarioToCreated);
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario login(UsuarioDTO usuarioDTO) {
        String correoElectronico = usuarioDTO.getCorreoElectronico();
        String contraseña = usuarioDTO.getContrasena();
        // Buscar el usuario por el correo electrónico
        Optional<Usuario> optionalUsuario = usuarioRepository.findByCorreoElectronico(correoElectronico);
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            // Verificar la contraseña
            if (usuario.getContraseña().equals(contraseña)) {
                // La contraseña es correcta, devolver el DTO del usuario
                return usuario;
            }
        }
        // El usuario no existe o la contraseña es incorrecta
        return null;
    }

    public Usuario updateUsuario(UsuarioDTO usuarioDTO) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(usuarioDTO.getIdUsuario());
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            // Actualizar los campos necesarios del usuario
            usuario.setPrimerNombre(usuarioDTO.getPrimerNombre());
            usuario.setSegundoNombre(usuarioDTO.getSegundoNombre());
            usuario.setPrimerApellido(usuarioDTO.getPrimerApellido());
            usuario.setSegundoApellido(usuarioDTO.getSegundoApellido());
            usuario.setIdRol(usuarioDTO.getIdRol());
            if (usuarioDTO.getDocumentoIdentidad() != null) {
                usuario.setDocumentoIdentidad(usuarioDTO.getDocumentoIdentidad());
            }
            if (usuarioDTO.getCorreoElectronico() != null) {
                usuario.setCorreoElectronico(usuarioDTO.getCorreoElectronico());
            }
            // Guardar los cambios en la base de datos
            return usuarioRepository.save(usuario);
        } else {
            return null;
        }
    }

    @Override
    public Usuario deleteUsuario(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(null);
        if(usuario != null){
            usuarioRepository.delete(usuario);
            return usuario;
        }
        return null;
    }

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

}
