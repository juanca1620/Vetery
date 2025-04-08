package com.vetery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.vetery.dto.ClienteCreateDto;
import com.vetery.dto.ClienteResponseDto;
import com.vetery.entity.Cliente;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

	Cliente createDtoToCliente (ClienteCreateDto dto);
	
	@Mapping(source = "veterinaria.id",target = "veterinariaId")
	ClienteResponseDto clienteToResponseDto (Cliente cliente);
}
