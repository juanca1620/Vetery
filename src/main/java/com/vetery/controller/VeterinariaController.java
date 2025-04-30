package com.vetery.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vetery.dto.LoginDto;
import com.vetery.dto.VeterinariaCreateDto;
import com.vetery.dto.VeterinariaResponseDto;
import com.vetery.service.VeterinariaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/veterinaria")
@Tag(name = "Veterinarias", description = "Endpoints para registro y login de veterinarias")
public class VeterinariaController {

	@Autowired
	private VeterinariaService service;

	public VeterinariaController(VeterinariaService service) {
		this.service = service;
	}

	@Operation(
			summary = "Registro de Veterinaria",
			description = "Registra una nueva veterinaria en el sistema."
	)
	@PostMapping("/register")
	public ResponseEntity<VeterinariaResponseDto> register(@Valid @RequestBody VeterinariaCreateDto dto) {
		VeterinariaResponseDto resp = service.registrarVeterinaria(dto);
		return new ResponseEntity<>(resp, HttpStatus.CREATED);
	}

	@Operation(
			summary = "Login de Veterinaria",
			description = "Permite iniciar sesión con las credenciales de una veterinaria registrada."
	)
	@PostMapping("/login")
	public ResponseEntity<VeterinariaResponseDto> login(@Valid @RequestBody LoginDto dto) {
		VeterinariaResponseDto resp = service.login(dto);
		return new ResponseEntity<>(resp, HttpStatus.CREATED);
	}
}