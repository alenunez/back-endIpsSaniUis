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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Proyecto.BackIpsSaniUis.dto.HistoriaClinicaDTO;
import com.Proyecto.BackIpsSaniUis.mappers.HistoriaClinicaMapper;
import com.Proyecto.BackIpsSaniUis.mappers.HistoriaClinicaMapperImpl;
import com.Proyecto.BackIpsSaniUis.model.HistoriaClinica;
import com.Proyecto.BackIpsSaniUis.service.interfaces.IHistoriaClinicaService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/historiaClinica")
public class HistoriaClinicaController {
        
    IHistoriaClinicaService iHistoriaClinicaService;

    @PostMapping("/insert")
    public ResponseEntity<HistoriaClinicaDTO> createHistoriaClinica(@RequestBody HistoriaClinicaDTO historiaClinicaDTO) {

        HistoriaClinicaDTO historiaClinicaDTOCreated = HistoriaClinicaMapperImpl.INSTANCE.toDto(iHistoriaClinicaService.createHistoriaClinica(historiaClinicaDTO));

        return new ResponseEntity<>(historiaClinicaDTOCreated, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<HistoriaClinicaDTO>> getHistoriaClinica(){
        List<HistoriaClinica> listaHistoriaClinica = iHistoriaClinicaService.getAllHistoriaClinica();
        if(listaHistoriaClinica.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listaHistoriaClinica.stream().map(HistoriaClinicaMapper.INSTANCE
        ::toDto).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<HistoriaClinicaDTO> getById(@PathVariable(value = "id", required = true) Long aId){
        HistoriaClinica historiaClinica = iHistoriaClinicaService.findById(aId);
        if(historiaClinica ==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HistoriaClinicaMapper.INSTANCE.toDto(historiaClinica), HttpStatus.OK);
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteHistoriaClinica(@PathVariable(value = "id", required = true) Long aId){
        HistoriaClinica historiaClinica = iHistoriaClinicaService.deleteHistoriaClinica(aId);
        if(historiaClinica ==null){
            return new ResponseEntity<>("No existe la historia clinica con el id ingresado",HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("Se ha eliminado el registro", HttpStatus.OK);
    }

    @Autowired
    public HistoriaClinicaController(IHistoriaClinicaService iHistoriaClinicaService) {
        this.iHistoriaClinicaService = iHistoriaClinicaService;
    }

}
