package com.vetery.service;

import java.util.List;

import com.vetery.dto.DisponibilidadCreateDto;
import com.vetery.dto.DisponibilidadResponseDto;
import com.vetery.entity.Veterinario;

public interface DisponibilidadService {

	DisponibilidadResponseDto crearDisponibilidad (DisponibilidadCreateDto dto);
	
	DisponibilidadResponseDto eliminarDisponibilidadPorId (Long id);
	
	List<DisponibilidadResponseDto> disponibilidadesVeterinarioId (Long id);
}
