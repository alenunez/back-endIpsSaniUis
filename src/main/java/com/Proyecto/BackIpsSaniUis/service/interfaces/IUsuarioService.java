package com.Proyecto.BackIpsSaniUis.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Proyecto.BackIpsSaniUis.dto.UsuarioDTO;
import com.Proyecto.BackIpsSaniUis.model.Usuario;

@Service
public interface IUsuarioService {

    public Usuario createUsuario(UsuarioDTO usuarioDTO);

    public List<Usuario> getAllUsuarios();

    public Usuario findById(Long id);

    public Usuario login(UsuarioDTO usuarioDTO);

    public Usuario updateUsuario(UsuarioDTO usuarioDTO);

    public Usuario deleteUsuario(Long id);

}
