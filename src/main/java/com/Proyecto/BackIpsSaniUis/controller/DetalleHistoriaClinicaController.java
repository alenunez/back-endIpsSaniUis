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

import com.Proyecto.BackIpsSaniUis.dto.DetalleHistoriaClinicaDTO;
import com.Proyecto.BackIpsSaniUis.mappers.DetalleHistoriaClinicaMapper;
import com.Proyecto.BackIpsSaniUis.mappers.DetalleHistoriaClinicaMapperImpl;
import com.Proyecto.BackIpsSaniUis.model.DetalleHistoriaClinica;
import com.Proyecto.BackIpsSaniUis.service.interfaces.IDetalleHistoriaClinicaService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/detalleHistoriaClinica")
public class DetalleHistoriaClinicaController {
            
    IDetalleHistoriaClinicaService iDetalleHistoriaClinicaService;

    @PostMapping("/insert")
    public ResponseEntity<DetalleHistoriaClinicaDTO> createDetalleHistoriaClinica(@RequestBody DetalleHistoriaClinicaDTO detalleHistoriaClinicaDTO) {

        DetalleHistoriaClinicaDTO detalleHistoriaClinicaDTOCreated = DetalleHistoriaClinicaMapperImpl.INSTANCE.toDto(iDetalleHistoriaClinicaService.createDetalleHistoriaClinica(detalleHistoriaClinicaDTO));

        return new ResponseEntity<>(detalleHistoriaClinicaDTOCreated, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<DetalleHistoriaClinicaDTO>> getDetalleHistoriaClinica(){
        List<DetalleHistoriaClinica> listaDetalleHistoriaClinica = iDetalleHistoriaClinicaService.getAllDetalleHistoriaClinica();
        if(listaDetalleHistoriaClinica.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listaDetalleHistoriaClinica.stream().map(DetalleHistoriaClinicaMapper.INSTANCE
        ::toDto).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<DetalleHistoriaClinicaDTO> getById(@PathVariable(value = "id", required = true) Long aId){
        DetalleHistoriaClinica detalleHistoriaClinica = iDetalleHistoriaClinicaService.findById(aId);
        if(detalleHistoriaClinica ==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(DetalleHistoriaClinicaMapper.INSTANCE.toDto(detalleHistoriaClinica), HttpStatus.OK);
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteDetalleHistoriaClinica(@PathVariable(value = "id", required = true) Long aId){
        DetalleHistoriaClinica detalleHistoriaClinica = iDetalleHistoriaClinicaService.deleteDetalleHistoriaClinica(aId);
        if(detalleHistoriaClinica ==null){
            return new ResponseEntity<>("No existe el detalle de la historia clinica con el id ingresado",HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("Se ha eliminado el registro", HttpStatus.OK);
    }

    @Autowired
    public DetalleHistoriaClinicaController(IDetalleHistoriaClinicaService iDetalleHistoriaClinicaService) {
        this.iDetalleHistoriaClinicaService = iDetalleHistoriaClinicaService;
    }

}
