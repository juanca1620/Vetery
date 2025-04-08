package com.vetery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.vetery.dto.MascotaCreateDto;
import com.vetery.dto.MascotaResponseDto;
import com.vetery.entity.Mascota;

@Mapper(componentModel = "spring")
public interface MascotaMapper {

	Mascota createDtoToMascota (MascotaCreateDto dto);
	
	@Mapping(source = "cliente.id" ,target = "clienteId")
	MascotaResponseDto mascotaToResponseDto (Mascota mascota);
}
