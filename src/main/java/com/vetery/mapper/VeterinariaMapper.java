package com.vetery.mapper;

import org.mapstruct.Mapper;

import com.vetery.dto.VeterinariaCreateDto;
import com.vetery.dto.VeterinariaResponseDto;
import com.vetery.entity.Veterinaria;

@Mapper(componentModel = "spring")
public interface VeterinariaMapper {

	Veterinaria  createDtoToVeterinaria (VeterinariaCreateDto dto);
	
	VeterinariaResponseDto veterinariaToResponseDto (Veterinaria veterinaria);
	
}
