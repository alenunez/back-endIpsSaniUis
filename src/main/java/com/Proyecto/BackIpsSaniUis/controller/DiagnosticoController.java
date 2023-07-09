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

import com.Proyecto.BackIpsSaniUis.dto.DiagnosticoDTO;
import com.Proyecto.BackIpsSaniUis.mappers.DiagnosticoMapper;
import com.Proyecto.BackIpsSaniUis.mappers.DiagnosticoMapperImpl;
import com.Proyecto.BackIpsSaniUis.model.Diagnostico;
import com.Proyecto.BackIpsSaniUis.service.interfaces.IDiagnosticoService;

@RestController
@RequestMapping("/diagnostico")
public class DiagnosticoController {
        
    IDiagnosticoService iDiagnosticoService;

    @PostMapping("/insert")
    public ResponseEntity<DiagnosticoDTO> createDiagnostico(@RequestBody DiagnosticoDTO diagnosticoDTO) {

        DiagnosticoDTO diagnosticoDTOCreated = DiagnosticoMapperImpl.INSTANCE.toDto(iDiagnosticoService.createDiagnostico(diagnosticoDTO));

        return new ResponseEntity<>(diagnosticoDTOCreated, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<DiagnosticoDTO> updateDiagnostico(@RequestBody DiagnosticoDTO diagnosticoDTO) {

        DiagnosticoDTO diagnosticoDTOUpdate= DiagnosticoMapperImpl.INSTANCE.toDto(iDiagnosticoService.updateDiagnostico(diagnosticoDTO));

        if(diagnosticoDTOUpdate != null){
            return new ResponseEntity<>(diagnosticoDTOUpdate, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<DiagnosticoDTO>> getDiagnostico(){
        List<Diagnostico> listaDiagnosticos = iDiagnosticoService.getAllDiagnosticos();
        if(listaDiagnosticos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listaDiagnosticos.stream().map(DiagnosticoMapper.INSTANCE
        ::toDto).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<DiagnosticoDTO> getById(@PathVariable(value = "id", required = true) Long aId){
        Diagnostico diagnostico = iDiagnosticoService.findById(aId);
        if(diagnostico ==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(DiagnosticoMapper.INSTANCE.toDto(diagnostico), HttpStatus.OK);
    }

    @GetMapping("/idCita/{id}")
    public ResponseEntity<DiagnosticoDTO> getByCita(@PathVariable(value = "id", required = true) Long aId){
        Diagnostico diagnostico = iDiagnosticoService.findByCita(aId);
        if(diagnostico ==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(DiagnosticoMapper.INSTANCE.toDto(diagnostico), HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteDiagnostico(@PathVariable(value = "id", required = true) Long aId){
        Diagnostico diagnostico = iDiagnosticoService.deleteDiagnostico(aId);
        if(diagnostico ==null){
            return new ResponseEntity<>("No existe el diagnostico con el id ingresado",HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("Se ha eliminado el registro", HttpStatus.OK);
    }

    @Autowired
    public DiagnosticoController(IDiagnosticoService iDiagnosticoService) {
        this.iDiagnosticoService = iDiagnosticoService;
    }

}
