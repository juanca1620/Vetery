package com.vetery.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vetery.dto.VeterinarioCreateDto;
import com.vetery.dto.VeterinarioResponseDto;
import com.vetery.dto.VeterinarioUpdateDto;
import com.vetery.repository.VeterinarioRepository;
import com.vetery.service.VeterinarioService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("api/veterinario")
@Tag(name = "Veterinarios", description = "Operaciones relacionadas con los veterinarios")
public class VeterinarioController {

	@Autowired
	private VeterinarioService service;

	public VeterinarioController(VeterinarioService service) {
		this.service = service;
	}

	@Operation(
			summary = "Crear un nuevo veterinario",
			description = "Registra un nuevo veterinario en el sistema."
	)
	@PostMapping
	public ResponseEntity<VeterinarioResponseDto> crearVeterinario(@Valid @RequestBody VeterinarioCreateDto dto) {
		VeterinarioResponseDto resp = service.crearVeterinario(dto);
		return new ResponseEntity<>(resp, HttpStatus.CREATED);
	}

	@Operation(
			summary = "Obtener veterinarios por ID de veterinaria",
			description = "Devuelve una lista de veterinarios asociados a una veterinaria."
	)
	@GetMapping("/veterinaria/{id}")
	public ResponseEntity<List<VeterinarioResponseDto>> obtenerVeterinariosPorVeterinariaId(@PathVariable Long id) {
		List<VeterinarioResponseDto> resp = service.obtenerVeterinariosPorVeterinariaId(id);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	@Operation(
			summary = "Obtener veterinario por ID",
			description = "Devuelve la información de un veterinario específico."
	)
	@GetMapping("/{id}")
	public ResponseEntity<VeterinarioResponseDto> obtenerVeterinarioPorId(@PathVariable Long id) {
		VeterinarioResponseDto resp = service.obtenerVeterinarioPorId(id);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	@Operation(
			summary = "Actualizar veterinario",
			description = "Modifica los datos de un veterinario existente."
	)
	@PutMapping
	public ResponseEntity<VeterinarioResponseDto> editarVeterinario(@Valid @RequestBody VeterinarioUpdateDto dto) {
		VeterinarioResponseDto resp = service.actualizarVeterinario(dto);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	@Operation(
			summary = "Eliminar veterinario",
			description = "Elimina un veterinario por su ID."
	)
	@DeleteMapping("/{id}")
	public ResponseEntity<VeterinarioResponseDto> eliminarVeterinario(@PathVariable Long id) {
		VeterinarioResponseDto resp = service.eliminarVeterinario(id);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}
}