package com.Proyecto.BackIpsSaniUis.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.Proyecto.BackIpsSaniUis.dto.DetalleHistoriaClinicaDTO;
import com.Proyecto.BackIpsSaniUis.model.DetalleHistoriaClinica;

@Mapper
public interface DetalleHistoriaClinicaMapper {

    DetalleHistoriaClinicaMapper INSTANCE = Mappers.getMapper(DetalleHistoriaClinicaMapper.class);

    @Mapping(source = "citaMedica.fechaCita", target = "fechaCitaCitaMedica")
    DetalleHistoriaClinicaDTO toDto(DetalleHistoriaClinica detalleHistoriaClinica);

    @Mapping(target = "citaMedica", ignore = true)
    @Mapping(target = "historiaClinica", ignore = true)
    DetalleHistoriaClinica toEntity(DetalleHistoriaClinicaDTO detalleHistoriaClinicaDTO);
}
