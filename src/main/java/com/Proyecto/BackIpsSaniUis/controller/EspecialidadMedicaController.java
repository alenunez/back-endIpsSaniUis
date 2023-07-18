package com.Proyecto.BackIpsSaniUis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import com.Proyecto.BackIpsSaniUis.dto.EspecialidadMedicaDTO;
import com.Proyecto.BackIpsSaniUis.mappers.EspecialidadMedicaMapper;
import com.Proyecto.BackIpsSaniUis.mappers.EspecialidadMedicaMapperImpl;
import com.Proyecto.BackIpsSaniUis.model.EspecialidadMedica;
import com.Proyecto.BackIpsSaniUis.service.interfaces.IEspecialidadMedicaService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/especialidadMedica")
public class EspecialidadMedicaController {
            
    IEspecialidadMedicaService iEspecialidadMedicaService;

    @PostMapping("/insert")
    public ResponseEntity<EspecialidadMedicaDTO> createEspecialidadMedica(@RequestBody EspecialidadMedicaDTO especialidadMedicaDTO) {

        EspecialidadMedicaDTO especialidadMedicaDTOCreated = EspecialidadMedicaMapperImpl.INSTANCE.toDto(iEspecialidadMedicaService.createEspecialidadMedica(especialidadMedicaDTO));

        return new ResponseEntity<>(especialidadMedicaDTOCreated, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<EspecialidadMedicaDTO> updateEspecialidadMedica(@RequestBody EspecialidadMedicaDTO especialidadMedicaDTO) {

        EspecialidadMedicaDTO especialidadMedicaDTOUpdate= EspecialidadMedicaMapperImpl.INSTANCE.toDto(iEspecialidadMedicaService.updateEspecialidadMedica(especialidadMedicaDTO));

        if(especialidadMedicaDTOUpdate != null){
            return new ResponseEntity<>(especialidadMedicaDTOUpdate, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    @GetMapping("/all")
    public ResponseEntity<List<EspecialidadMedicaDTO>> getEspecialidadMedica(){
        List<EspecialidadMedica> listaEspecialidadMedica = iEspecialidadMedicaService.getAllEspecialidadMedica();
        if(listaEspecialidadMedica.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listaEspecialidadMedica.stream().map(EspecialidadMedicaMapper.INSTANCE
        ::toDto).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<EspecialidadMedicaDTO> getById(@PathVariable(value = "id", required = true) Long aId){
        EspecialidadMedica especialidadMedica = iEspecialidadMedicaService.findById(aId);
        if(especialidadMedica ==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(EspecialidadMedicaMapper.INSTANCE.toDto(especialidadMedica), HttpStatus.OK);
    }
    
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Object> deleteEspecialidadMedica(@PathVariable(value = "id", required = true) Long aId) {
        EspecialidadMedica especialidadMedica = iEspecialidadMedicaService.deleteEspecialidadMedica(aId);
        if (especialidadMedica == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("{\"message\": \"No existe la especialidad medica con el id ingresado\"}");
        }
        
        // Crear un objeto JSON para devolver como respuesta
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> jsonResponse = new HashMap<>();
        jsonResponse.put("message", "Se ha eliminado el registro");
        
        return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);
    }

    @Autowired
    public EspecialidadMedicaController(IEspecialidadMedicaService iEspecialidadMedicaService) {
        this.iEspecialidadMedicaService = iEspecialidadMedicaService;
    }
 
}
