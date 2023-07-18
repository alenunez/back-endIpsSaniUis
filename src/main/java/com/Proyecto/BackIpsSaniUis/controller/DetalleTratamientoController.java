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

import com.Proyecto.BackIpsSaniUis.dto.DetalleTratamientoDTO;
import com.Proyecto.BackIpsSaniUis.mappers.DetalleTratamientoMapper;
import com.Proyecto.BackIpsSaniUis.mappers.DetalleTratamientoMapperImpl;
import com.Proyecto.BackIpsSaniUis.model.DetalleTratamiento;
import com.Proyecto.BackIpsSaniUis.service.interfaces.IDetalleTratamientoService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/detalleTratamiento")
public class DetalleTratamientoController {
            
    IDetalleTratamientoService iDetalleTratamientoService;

    @PostMapping("/insert")
    public ResponseEntity<DetalleTratamientoDTO> createDetalleTratamiento(@RequestBody DetalleTratamientoDTO detalleTratamientoDTO) {

        DetalleTratamientoDTO detalleTratamientoDTOCreated = DetalleTratamientoMapperImpl.INSTANCE.toDto(iDetalleTratamientoService.createDetalleTratamiento(detalleTratamientoDTO));

        return new ResponseEntity<>(detalleTratamientoDTOCreated, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<DetalleTratamientoDTO>> getDetalleTratamiento(){
        List<DetalleTratamiento> listaDetalleTratamiento = iDetalleTratamientoService.getAllDetalleTratamiento();
        if(listaDetalleTratamiento.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listaDetalleTratamiento.stream().map(DetalleTratamientoMapper.INSTANCE
        ::toDto).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<DetalleTratamientoDTO> getById(@PathVariable(value = "id", required = true) Long aId){
        DetalleTratamiento detalleTratamiento = iDetalleTratamientoService.findById(aId);
        if(detalleTratamiento ==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(DetalleTratamientoMapper.INSTANCE.toDto(detalleTratamiento), HttpStatus.OK);
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteDetalleTratamiento(@PathVariable(value = "id", required = true) Long aId){
        DetalleTratamiento detalleTratamiento = iDetalleTratamientoService.deleteDetalleTratamiento(aId);
        if(detalleTratamiento ==null){
            return new ResponseEntity<>("No existe el detalle tratamiento con el id ingresado",HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("Se ha eliminado el registro", HttpStatus.OK);
    }

    @Autowired
    public DetalleTratamientoController(IDetalleTratamientoService iDetalleTratamientoService) {
        this.iDetalleTratamientoService = iDetalleTratamientoService;
    }

}
