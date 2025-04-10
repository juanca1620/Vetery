package com.vetery.service;

import java.util.List;

import com.vetery.dto.ClienteCreateDto;
import com.vetery.dto.ClienteResponseDto;
import com.vetery.dto.ClienteUpdateDto;

public interface ClienteService {
	
	ClienteResponseDto crearCliente (ClienteCreateDto dto);
	
	List <ClienteResponseDto> obtenerClientesPorVeterinariaId(Long id);
	
	ClienteResponseDto actualizarCliente (ClienteUpdateDto dto);
	
	ClienteResponseDto eliminarCliente (Long id);
	
	ClienteResponseDto obtenerClientePorId (Long id);
}
