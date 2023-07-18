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

import com.Proyecto.BackIpsSaniUis.dto.MedicoDTO;
import com.Proyecto.BackIpsSaniUis.mappers.MedicoMapper;
import com.Proyecto.BackIpsSaniUis.mappers.MedicoMapperImpl;
import com.Proyecto.BackIpsSaniUis.model.Medico;
import com.Proyecto.BackIpsSaniUis.service.interfaces.IMedicoService;

@RestController
@RequestMapping("/medico")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MedicoController {
            
    IMedicoService iMedicoService;

    @PostMapping("/insert")
    public ResponseEntity<MedicoDTO> createMedico(@RequestBody MedicoDTO medicoDTO) {

        MedicoDTO medicoDTOCreated = MedicoMapperImpl.INSTANCE.toDto(iMedicoService.createMedico(medicoDTO));

        return new ResponseEntity<>(medicoDTOCreated, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MedicoDTO>> getMedico(){
        List<Medico> listaMedicos = iMedicoService.getAllMedicos();
        if(listaMedicos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listaMedicos.stream().map(MedicoMapper.INSTANCE
        ::toDto).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/especialidad/{id}")
    public ResponseEntity<List<MedicoDTO>> getMedicosPorEspecialidad(@PathVariable(value = "id", required = true) Long aId){
        List<Medico> listaMedicos = iMedicoService.findByEspecialidad(aId);
        if(listaMedicos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listaMedicos.stream().map(MedicoMapper.INSTANCE
        ::toDto).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<MedicoDTO> getById(@PathVariable(value = "id", required = true) Long aId){
        Medico medico = iMedicoService.findById(aId);
        if(medico ==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(MedicoMapper.INSTANCE.toDto(medico), HttpStatus.OK);
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteMedico(@PathVariable(value = "id", required = true) Long aId){
        Medico medico = iMedicoService.deleteMedico(aId);
        if(medico ==null){
            return new ResponseEntity<>("No existe el medico con el id ingresado",HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("Se ha eliminado el registro", HttpStatus.OK);
    }

    @Autowired
    public MedicoController(IMedicoService iMedicoService) {
        this.iMedicoService = iMedicoService;
    }

}
