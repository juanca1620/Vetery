package com.vetery.mapper;

import org.mapstruct.Mapper;

import com.vetery.dto.AdministradorCreateDto;
import com.vetery.dto.AdministradorResponseDto;
import com.vetery.entity.Administrador;

@Mapper(componentModel = "spring")
public interface AdministradorMapper {

	Administrador createDtoToAdministrador (AdministradorCreateDto dto);
	
	AdministradorResponseDto administradorToResponseDto (Administrador administrador);
}
