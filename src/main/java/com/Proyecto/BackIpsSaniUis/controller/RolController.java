package com.Proyecto.BackIpsSaniUis.controller;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Proyecto.BackIpsSaniUis.dto.RolDTO;
import com.Proyecto.BackIpsSaniUis.mappers.RolMapper;
import com.Proyecto.BackIpsSaniUis.mappers.RolMapperImpl;
import com.Proyecto.BackIpsSaniUis.model.Rol;
import com.Proyecto.BackIpsSaniUis.service.interfaces.IRolService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/rol")
public class RolController {

    IRolService iRolService;

    @PostMapping("/insert")
    public ResponseEntity<RolDTO> createUsuario(@RequestBody RolDTO rolDTO) {

        RolDTO rolDTOCreated = RolMapperImpl.INSTANCE.rolToRolDTO(iRolService.createRol(rolDTO));

        return new ResponseEntity<>(rolDTOCreated, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<RolDTO> updateUsuario(@RequestBody RolDTO rolDTO) {

        RolDTO rolDTOUpdate= RolMapperImpl.INSTANCE.rolToRolDTO(iRolService.updateRol(rolDTO));

        if(rolDTOUpdate != null){
            return new ResponseEntity<>(rolDTOUpdate, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    @GetMapping("/all")
    public ResponseEntity<List<RolDTO>> getRoles(){
        List<Rol> listaRoles = iRolService.getAllRol();
        if(listaRoles.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listaRoles.stream().map(RolMapper.INSTANCE
        ::rolToRolDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<RolDTO> getById(@PathVariable(value = "id", required = true) Long aId){
        Rol rol = iRolService.findById(aId);
        if(rol ==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(RolMapper.INSTANCE.rolToRolDTO(rol), HttpStatus.OK);
    }
    
    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteRol(@PathVariable(value = "id", required = true) Long aId){
        Rol rol = iRolService.deleteRol(aId);
        if(rol ==null){
            return new ResponseEntity<>("No existe el rol con el id ingresado",HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("Se ha eliminado el registro", HttpStatus.OK);
    }

    @Autowired
    public RolController(IRolService iRolService) {
        this.iRolService = iRolService;
    }
    
}
