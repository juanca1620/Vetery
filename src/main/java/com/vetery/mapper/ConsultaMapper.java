package com.vetery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.vetery.dto.ConsultaCreateDto;
import com.vetery.dto.ConsultaResponseDto;
import com.vetery.entity.Consulta;

@Mapper(componentModel = "spring")
public interface ConsultaMapper {

	Consulta createDtoToConsulta (ConsultaCreateDto dto);
	
	@Mapping(source = "mascota.id", target = "mascotaId")
	ConsultaResponseDto consultaToResponseDto (Consulta consulta);
}
