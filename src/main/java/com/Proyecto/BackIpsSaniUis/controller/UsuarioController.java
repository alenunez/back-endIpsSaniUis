package com.Proyecto.BackIpsSaniUis.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Proyecto.BackIpsSaniUis.dto.UsuarioDTO;
import com.Proyecto.BackIpsSaniUis.mappers.UsuarioMappers;
import com.Proyecto.BackIpsSaniUis.mappers.UsuarioMappersImpl;
import com.Proyecto.BackIpsSaniUis.model.Usuario;
import com.Proyecto.BackIpsSaniUis.service.interfaces.IUsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    IUsuarioService iUsuarioService;

    @PostMapping("/insert")
    public ResponseEntity<UsuarioDTO> createUsuario(@RequestBody UsuarioDTO usuarioDTO) {

        UsuarioDTO usuarioDTOCreated = UsuarioMappersImpl.INSTANCE.usuarioToUsuarioDTO(iUsuarioService.createUsuario(usuarioDTO));

        return new ResponseEntity<>(usuarioDTOCreated, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<UsuarioDTO> updateUsuario(@RequestBody UsuarioDTO usuarioDTO) {

        UsuarioDTO usuarioDTOUpdate= UsuarioMappersImpl.INSTANCE.usuarioToUsuarioDTO(iUsuarioService.updateUsuario(usuarioDTO));

        if(usuarioDTOUpdate != null){
            return new ResponseEntity<>(usuarioDTOUpdate, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UsuarioDTO loginRequest) {
        UsuarioDTO usuarioLogin = UsuarioMappersImpl.INSTANCE.usuarioToUsuarioDTO(iUsuarioService.login(loginRequest));
        if (usuarioLogin != null) {
            Long rol = usuarioLogin.getIdRol();

            // Devolver el valor de rol en la respuesta con el estado CREATED
            return ResponseEntity.status(HttpStatus.CREATED).body(rol);
        }
    
        // Devolver un objeto JSON con el mensaje de error
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"message\": \"Credenciales inválidas\"}");
    }
    


    @GetMapping("/all")
    public ResponseEntity<List<UsuarioDTO>> getUsuarios(){
        List<Usuario> listaUsuarios = iUsuarioService.getAllUsuarios();
        if(listaUsuarios.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listaUsuarios.stream().map(UsuarioMappers.INSTANCE
        ::usuarioToUsuarioDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UsuarioDTO> getById(@PathVariable(value = "id", required = true) Long aId){
        Usuario usuario = iUsuarioService.findById(aId);
        if(usuario ==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(UsuarioMappers.INSTANCE.usuarioToUsuarioDTO(usuario), HttpStatus.OK);
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable(value = "id", required = true) Long aId){
        Usuario usuario = iUsuarioService.deleteUsuario(aId);
        if(usuario ==null){
            return new ResponseEntity<>("No existe el usuario con el id ingresado",HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("Se ha eliminado el registro", HttpStatus.OK);
    }

    @Autowired
    public UsuarioController(IUsuarioService iUsuarioService) {
        this.iUsuarioService = iUsuarioService;
    }

}
