package com.Proyecto.BackIpsSaniUis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.BackIpsSaniUis.model.Usuario;
import com.Proyecto.BackIpsSaniUis.repository.UsuarioRepository;
import com.Proyecto.BackIpsSaniUis.service.interfaces.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

    UsuarioRepository usuarioRepository;

    @Override
    public void createUsuario(Usuario usuarioDTO) {
        usuarioRepository.save(usuarioDTO);
        

   }

   @Autowired
   public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
       this.usuarioRepository = usuarioRepository;
   }
    
}
