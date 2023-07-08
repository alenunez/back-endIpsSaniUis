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

import com.Proyecto.BackIpsSaniUis.dto.CitaMedicaDTO;
import com.Proyecto.BackIpsSaniUis.mappers.CitaMedicaMapper;
import com.Proyecto.BackIpsSaniUis.mappers.CitaMedicaMapperImpl;
import com.Proyecto.BackIpsSaniUis.model.CitaMedica;
import com.Proyecto.BackIpsSaniUis.service.interfaces.ICitaMedicaService;

@RestController
@RequestMapping("/citaMedica")
public class CitaMedicaController {

    ICitaMedicaService iCitaMedicaService;

    @PostMapping("/insert")
    public ResponseEntity<?> createCitaMedica(@RequestBody CitaMedicaDTO citaMedicaDTO) {
        CitaMedica citaMedica = iCitaMedicaService.createCitaMedica(citaMedicaDTO);
    
        if (citaMedica != null) {
            CitaMedicaDTO citaMedicaDTOCreated = CitaMedicaMapper.INSTANCE.toDto(citaMedica);
            return new ResponseEntity<>(citaMedicaDTOCreated, HttpStatus.CREATED);
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "No se puede crear la cita médica en el horario especificado");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
    

    @PutMapping("/update")
    public ResponseEntity<CitaMedicaDTO> updateCitaMedica(@RequestBody CitaMedicaDTO citaMedicaDTO) {

        CitaMedicaDTO citaMedicaDTOUpdate= CitaMedicaMapperImpl.INSTANCE.toDto(iCitaMedicaService.updateCitaMedica(citaMedicaDTO));

        if(citaMedicaDTOUpdate != null){
            return new ResponseEntity<>(citaMedicaDTOUpdate, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CitaMedicaDTO>> getCitaMedica(){
        List<CitaMedica> listaCitaMedica = iCitaMedicaService.getAllCitaMedica();
        if(listaCitaMedica.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listaCitaMedica.stream().map(CitaMedicaMapper.INSTANCE
        ::toDto).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/all/usuario/id/{id}")
    public ResponseEntity<List<CitaMedicaDTO>> getCitaMedicaUsuario(@PathVariable(value = "id", required = true) Long aId){
        List<CitaMedica> listaCitaMedica = iCitaMedicaService.getAllCitaMedicaUsuario(aId);
        if(listaCitaMedica.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listaCitaMedica.stream().map(CitaMedicaMapper.INSTANCE
        ::toDto).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<CitaMedicaDTO> getById(@PathVariable(value = "id", required = true) Long aId){
        CitaMedica citaMedica = iCitaMedicaService.findById(aId);
        if(citaMedica ==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(CitaMedicaMapper.INSTANCE.toDto(citaMedica), HttpStatus.OK);
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Map<String, String>> deleteCitaMedica(@PathVariable(value = "id", required = true) Long aId) {
        CitaMedica citaMedica = iCitaMedicaService.deleteCitaMedica(aId);
        if (citaMedica == null) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "No existe la cita medica con el id ingresado");
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        }
        Map<String, String> response = new HashMap<>();
        response.put("message", "Se ha eliminado el registro");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Autowired
    public CitaMedicaController(ICitaMedicaService iCitaMedicaService) {
        this.iCitaMedicaService = iCitaMedicaService;
    }

}
