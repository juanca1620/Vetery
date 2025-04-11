package com.vetery.service;

import java.util.List;

import com.vetery.dto.ConsultorioCreateDto;
import com.vetery.dto.ConsultorioResponseDto;

public interface ConsultorioService {
	
	ConsultorioResponseDto crearConsultorio (ConsultorioCreateDto dto,Long veterinariaId);
	
	ConsultorioResponseDto eliminarConsultorio (Long id);
	
	ConsultorioResponseDto obtenerConsultorioPorId (Long id);
	
	List<ConsultorioResponseDto> obtenerConsultoriosPorVeterinaria (Long id);
}
