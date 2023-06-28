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

import com.Proyecto.BackIpsSaniUis.dto.MarcaMedicamentoDTO;
import com.Proyecto.BackIpsSaniUis.mappers.MarcaMedicamentoMapper;
import com.Proyecto.BackIpsSaniUis.mappers.MarcaMedicamentoMapperImpl;
import com.Proyecto.BackIpsSaniUis.model.MarcaMedicamento;
import com.Proyecto.BackIpsSaniUis.service.interfaces.IMarcaMedicamentoService;

@RestController
@RequestMapping("/marcaMedicamento")
public class MarcaMedicamentoController {
    
    IMarcaMedicamentoService iMarcaMedicamentoService;

    @PostMapping("/insert")
    public ResponseEntity<MarcaMedicamentoDTO> createMarcaMedicamento(@RequestBody MarcaMedicamentoDTO marcaMedicamentoDTO) {

        MarcaMedicamentoDTO marcaMedicamentoDTOCreated = MarcaMedicamentoMapperImpl.INSTANCE.toDto(iMarcaMedicamentoService.createMarcaMedicamento(marcaMedicamentoDTO));

        return new ResponseEntity<>(marcaMedicamentoDTOCreated, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<MarcaMedicamentoDTO> updateUsuario(@RequestBody MarcaMedicamentoDTO marcaMedicamentoDTO) {

        MarcaMedicamentoDTO marcaMedicamentoDTOUpdate= MarcaMedicamentoMapperImpl.INSTANCE.toDto(iMarcaMedicamentoService.updateMarcaMedicamento(marcaMedicamentoDTO));

        if(marcaMedicamentoDTOUpdate != null){
            return new ResponseEntity<>(marcaMedicamentoDTOUpdate, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    @GetMapping("/all")
    public ResponseEntity<List<MarcaMedicamentoDTO>> getRoles(){
        List<MarcaMedicamento> listaMarcaMedicamentos = iMarcaMedicamentoService.getAllMarcaMedicamentos();
        if(listaMarcaMedicamentos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listaMarcaMedicamentos.stream().map(MarcaMedicamentoMapper.INSTANCE
        ::toDto).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<MarcaMedicamentoDTO> getById(@PathVariable(value = "id", required = true) Long aId){
        MarcaMedicamento marcaMedicamento = iMarcaMedicamentoService.findById(aId);
        if(marcaMedicamento ==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(MarcaMedicamentoMapper.INSTANCE.toDto(marcaMedicamento), HttpStatus.OK);
    }
    
    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteRol(@PathVariable(value = "id", required = true) Long aId){
        MarcaMedicamento marcaMedicamento = iMarcaMedicamentoService.deleteMarcaMedicamento(aId);
        if(marcaMedicamento ==null){
            return new ResponseEntity<>("No existe la marca de medicamento con el id ingresado",HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("Se ha eliminado el registro", HttpStatus.OK);
    }

    @Autowired
    public MarcaMedicamentoController(IMarcaMedicamentoService iMarcaMedicamentoService) {
        this.iMarcaMedicamentoService = iMarcaMedicamentoService;
    }
  
}
