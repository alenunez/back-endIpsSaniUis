package com.Proyecto.BackIpsSaniUis.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.Proyecto.BackIpsSaniUis.dto.EspecialidadMedicaDTO;
import com.Proyecto.BackIpsSaniUis.model.EspecialidadMedica;

@Mapper
public interface EspecialidadMedicaMapper {

    EspecialidadMedicaMapper INSTANCE = Mappers.getMapper(EspecialidadMedicaMapper.class);

    @Mapping(source = "idEspecialidadMedica", target = "idEspecialidadMedica")
    EspecialidadMedicaDTO toDto(EspecialidadMedica entidad);

    @Mapping(source = "idEspecialidadMedica", target = "idEspecialidadMedica")
    EspecialidadMedica toEntity(EspecialidadMedicaDTO dto);

}
