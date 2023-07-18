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

import com.Proyecto.BackIpsSaniUis.dto.TratamientoDTO;
import com.Proyecto.BackIpsSaniUis.mappers.TratamientoMapper;
import com.Proyecto.BackIpsSaniUis.mappers.TratamientoMapperImpl;
import com.Proyecto.BackIpsSaniUis.model.Tratamiento;
import com.Proyecto.BackIpsSaniUis.service.interfaces.ITratamientoService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/tratamiento")
public class TratamientoController {
    
    ITratamientoService iTratamientoService;

    @PostMapping("/insert")
    public ResponseEntity<TratamientoDTO> createTratamiento(@RequestBody TratamientoDTO tratamientoDTO) {

        TratamientoDTO tratamientoDTOCreated = TratamientoMapperImpl.INSTANCE.toDto(iTratamientoService.createTratamiento(tratamientoDTO));

        return new ResponseEntity<>(tratamientoDTOCreated, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<TratamientoDTO> updateTratamiento(@RequestBody TratamientoDTO tratamientoDTO) {

        TratamientoDTO tratamientoDTOUpdate= TratamientoMapperImpl.INSTANCE.toDto(iTratamientoService.updateTratamiento(tratamientoDTO));

        if(tratamientoDTOUpdate != null){
            return new ResponseEntity<>(tratamientoDTOUpdate, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TratamientoDTO>> getTratamiento(){
        List<Tratamiento> listaTratamientos = iTratamientoService.getAllTratamientos();
        if(listaTratamientos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listaTratamientos.stream().map(TratamientoMapper.INSTANCE
        ::toDto).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<TratamientoDTO> getById(@PathVariable(value = "id", required = true) Long aId){
        Tratamiento tratamiento = iTratamientoService.findById(aId);
        if(tratamiento ==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(TratamientoMapper.INSTANCE.toDto(tratamiento), HttpStatus.OK);
    }

    @GetMapping("/idCita/{id}")
    public ResponseEntity<TratamientoDTO> getByCita(@PathVariable(value = "id", required = true) Long aId){
        Tratamiento tratamiento = iTratamientoService.getTratamientoPorCita(aId);
        if(tratamiento ==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(TratamientoMapper.INSTANCE.toDto(tratamiento), HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteTratamiento(@PathVariable(value = "id", required = true) Long aId){
        Tratamiento tratamiento = iTratamientoService.deleteTratamiento(aId);
        if(tratamiento ==null){
            return new ResponseEntity<>("No existe el tratamiento con el id ingresado",HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("Se ha eliminado el registro", HttpStatus.OK);
    }

    @Autowired
    public TratamientoController(ITratamientoService iTratamientoService) {
        this.iTratamientoService = iTratamientoService;
    }

}
