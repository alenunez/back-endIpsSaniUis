package com.Proyecto.BackIpsSaniUis.service.interfaces;

import org.springframework.stereotype.Service;

import com.Proyecto.BackIpsSaniUis.model.Usuario;

@Service
public interface IUsuarioService {

	void createUsuario(  Usuario usuarioDTO);

}

