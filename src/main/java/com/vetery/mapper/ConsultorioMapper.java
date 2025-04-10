package com.vetery.mapper;

import org.mapstruct.Mapper;

import com.vetery.dto.ConsultorioCreateDto;
import com.vetery.dto.ConsultorioResponseDto;
import com.vetery.entity.Consultorio;

@Mapper(componentModel = "spring")
public interface ConsultorioMapper {

	Consultorio CreateDtoToConsultorio (ConsultorioCreateDto dto);
	
	ConsultorioResponseDto consultorioToResponseDto (Consultorio consultorio);
}
