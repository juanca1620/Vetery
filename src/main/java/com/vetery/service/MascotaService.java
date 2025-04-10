package com.vetery.service;

import java.util.List;

import com.vetery.dto.ClienteCreateDto;
import com.vetery.dto.MascotaCreateDto;
import com.vetery.dto.MascotaResponseDto;
import com.vetery.dto.MascotaUpdateDto;

public interface MascotaService {

	MascotaResponseDto crearMascota (MascotaCreateDto dto);
	
	List <MascotaResponseDto> obtenerMascotasPorClienteId(Long id);
	
	MascotaResponseDto actualizarMascota (MascotaUpdateDto dto);
	
	MascotaResponseDto eliminarMascota (Long id);
	
	MascotaResponseDto obtenerMascotaPorId (Long id);
}
