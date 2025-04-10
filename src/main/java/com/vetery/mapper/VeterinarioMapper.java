package com.vetery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.vetery.dto.VeterinarioCreateDto;
import com.vetery.dto.VeterinarioResponseDto;
import com.vetery.entity.Veterinario;

@Mapper(componentModel = "spring")
public interface VeterinarioMapper {

	Veterinario createDtoToVeterinario (VeterinarioCreateDto dto);
	
	@Mapping(source = "veterinaria.id" , target = "veterinariaId")
	VeterinarioResponseDto veterinarioToResponseDto (Veterinario veterinario);
}
