package com.vetery.service;

import java.util.List;

import com.vetery.dto.VeterinarioCreateDto;
import com.vetery.dto.VeterinarioResponseDto;
import com.vetery.dto.VeterinarioUpdateDto;

public interface VeterinarioService {
	
	VeterinarioResponseDto crearVeterinario (VeterinarioCreateDto dto);
	
	List<VeterinarioResponseDto> obtenerVeterinariosPorVeterinariaId(Long id);
	
	VeterinarioResponseDto actualizarVeterinario (VeterinarioUpdateDto dto);
	
	VeterinarioResponseDto eliminarVeterinario (Long id);
	
	VeterinarioResponseDto obtenerVeterinarioPorId (Long id);
	
}
