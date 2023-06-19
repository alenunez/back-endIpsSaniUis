package com.Proyecto.BackIpsSaniUis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Proyecto.BackIpsSaniUis.dto.UsuarioDTO;
import com.Proyecto.BackIpsSaniUis.mappers.UsuarioMappersImpl;
import com.Proyecto.BackIpsSaniUis.model.Usuario;
import com.Proyecto.BackIpsSaniUis.repository.UsuarioRepository;
import com.Proyecto.BackIpsSaniUis.service.interfaces.IUsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

  IUsuarioService iUsuarioService;

  @PostMapping("/insert")
  public ResponseEntity<Usuario> createUsuario(@RequestBody UsuarioDTO usuarioDTO){


    Usuario usuario = UsuarioMappersImpl.INSTANCE.usuarioDTOToUsuario(usuarioDTO);
    iUsuarioService.createUsuario(usuario);

    return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    
  }

  @Autowired
  public UsuarioController(IUsuarioService iUsuarioService) {
      this.iUsuarioService =iUsuarioService;
  }

    
}
