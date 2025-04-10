package com.vetery.service;

import com.vetery.dto.LoginDto;
import com.vetery.dto.VeterinariaCreateDto;
import com.vetery.dto.VeterinariaResponseDto;

public interface VeterinariaService {

	VeterinariaResponseDto registrarVeterinaria (VeterinariaCreateDto dto);
	
	VeterinariaResponseDto login (LoginDto dto);
}
