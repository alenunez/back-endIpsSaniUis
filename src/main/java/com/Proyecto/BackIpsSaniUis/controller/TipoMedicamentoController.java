package com.Proyecto.BackIpsSaniUis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import com.Proyecto.BackIpsSaniUis.dto.TipoMedicamentoDTO;
import com.Proyecto.BackIpsSaniUis.mappers.TipoMedicamentoMapperImpl;
import com.Proyecto.BackIpsSaniUis.mappers.TipoMedicamentoMapper;
import com.Proyecto.BackIpsSaniUis.model.TipoMedicamento;
import com.Proyecto.BackIpsSaniUis.service.interfaces.ITipoMedicamentoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/tipoMedicamento")
public class TipoMedicamentoController {
        
    ITipoMedicamentoService iTipoMedicamentoService;

    @PostMapping("/insert")
    public ResponseEntity<TipoMedicamentoDTO> createTipoMedicamento(@RequestBody TipoMedicamentoDTO tipoMedicamentoDTO) {

        TipoMedicamentoDTO tipoMedicamentoDTOCreated = TipoMedicamentoMapperImpl.INSTANCE.toDto(iTipoMedicamentoService.createTipoMedicamento(tipoMedicamentoDTO));

        return new ResponseEntity<>(tipoMedicamentoDTOCreated, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<TipoMedicamentoDTO> updateTipoMedicamento(@RequestBody TipoMedicamentoDTO tipoMedicamentoDTO) {

        TipoMedicamentoDTO tipoMedicamentoDTOUpdate = TipoMedicamentoMapperImpl.INSTANCE.toDto(iTipoMedicamentoService.updateTipoMedicamento(tipoMedicamentoDTO));

        if(tipoMedicamentoDTOUpdate != null){
            return new ResponseEntity<>(tipoMedicamentoDTOUpdate, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    @GetMapping("/all")
    public ResponseEntity<List<TipoMedicamentoDTO>> getTipoMedicamento(){
        List<TipoMedicamento> listaTipoMedicamento = iTipoMedicamentoService.getAllTipoMedicamentos();
        if(listaTipoMedicamento.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listaTipoMedicamento.stream().map(TipoMedicamentoMapper.INSTANCE
        ::toDto).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<TipoMedicamentoDTO> getById(@PathVariable(value = "id", required = true) Long aId){
        TipoMedicamento tipoMedicamento = iTipoMedicamentoService.findById(aId);
        if(tipoMedicamento ==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(TipoMedicamentoMapper.INSTANCE.toDto(tipoMedicamento), HttpStatus.OK);
    }
    
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Object> deleteTipoMedicamento(@PathVariable(value = "id", required = true) Long aId) {
        TipoMedicamento tipoMedicamento = iTipoMedicamentoService.deleteTipoMedicamento(aId);
        if (tipoMedicamento == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("{\"message\": \"No existe la tipo medicamento con el id ingresado\"}");
        }
        
        // Crear un objeto JSON para devolver como respuesta
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> jsonResponse = new HashMap<>();
        jsonResponse.put("message", "Se ha eliminado el registro");
        
        return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);
    }

    @Autowired
    public TipoMedicamentoController(ITipoMedicamentoService iTipoMedicamentoService) {
        this.iTipoMedicamentoService = iTipoMedicamentoService;
    }
  
}
