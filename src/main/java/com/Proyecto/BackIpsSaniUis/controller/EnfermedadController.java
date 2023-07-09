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

import com.Proyecto.BackIpsSaniUis.dto.EnfermedadDTO;
import com.Proyecto.BackIpsSaniUis.mappers.EnfermedadMapper;
import com.Proyecto.BackIpsSaniUis.mappers.EnfermedadMapperImpl;
import com.Proyecto.BackIpsSaniUis.model.Enfermedad;
import com.Proyecto.BackIpsSaniUis.service.interfaces.IEnfermedadService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/enfermedad")
public class EnfermedadController {
        
    IEnfermedadService iEnfermedadService;

    @PostMapping("/insert")
    public ResponseEntity<EnfermedadDTO> createEnfermedad(@RequestBody EnfermedadDTO enfermedadDTO) {

        EnfermedadDTO enfermedadDTOCreated = EnfermedadMapperImpl.INSTANCE.toDto(iEnfermedadService.createEnfermedad(enfermedadDTO));

        return new ResponseEntity<>(enfermedadDTOCreated, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<EnfermedadDTO> updateEnfermedad(@RequestBody EnfermedadDTO enfermedadDTO) {

        EnfermedadDTO enfermedadDTOUpdate= EnfermedadMapperImpl.INSTANCE.toDto(iEnfermedadService.updateEnfermedad(enfermedadDTO));

        if(enfermedadDTOUpdate != null){
            return new ResponseEntity<>(enfermedadDTOUpdate, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    @GetMapping("/all")
    public ResponseEntity<List<EnfermedadDTO>> getEnfermedades(){
        List<Enfermedad> listaEnfermedad = iEnfermedadService.getAllEnfermedades();
        if(listaEnfermedad.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listaEnfermedad.stream().map(EnfermedadMapper.INSTANCE
        ::toDto).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<EnfermedadDTO> getById(@PathVariable(value = "id", required = true) Long aId){
        Enfermedad enfermedad = iEnfermedadService.findById(aId);
        if(enfermedad ==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(EnfermedadMapper.INSTANCE.toDto(enfermedad), HttpStatus.OK);
    }
    
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Object> deleteEnfermedad(@PathVariable(value = "id", required = true) Long aId) {
        Enfermedad enfermedad = iEnfermedadService.deleteEnfermedad(aId);
        if (enfermedad == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("{\"message\": \"No existe la enfermedad con el id ingresado\"}");
        }
        
        // Crear un objeto JSON para devolver como respuesta
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> jsonResponse = new HashMap<>();
        jsonResponse.put("message", "Se ha eliminado el registro");
        
        return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);
    }

    @Autowired
    public EnfermedadController(IEnfermedadService iEnfermedadService) {
        this.iEnfermedadService = iEnfermedadService;
    }
 
}
