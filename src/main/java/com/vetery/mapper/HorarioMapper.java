package com.vetery.mapper;

import org.mapstruct.Mapper;

import com.vetery.dto.HorarioCreateDto;
import com.vetery.dto.HorarioResponseDto;
import com.vetery.entity.Horario;

@Mapper(componentModel = "spring")
public interface HorarioMapper {

	Horario createDtoToHorario (HorarioCreateDto dto);
	
	HorarioResponseDto horarioToResponseDto (Horario horario);
}
