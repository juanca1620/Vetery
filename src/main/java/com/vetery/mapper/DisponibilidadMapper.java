package com.vetery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.vetery.dto.DisponibilidadCreateDto;
import com.vetery.dto.DisponibilidadResponseDto;
import com.vetery.entity.Disponibilidad;

@Mapper(componentModel = "spring")
public interface DisponibilidadMapper {

	Disponibilidad createDtoToDisponibilidad (DisponibilidadCreateDto dto);
	
	@Mapping(source = "veterinario.id" , target = "veterinarioId")
	DisponibilidadResponseDto disponibilidadToResponseDto (Disponibilidad disponibilidad);
}
