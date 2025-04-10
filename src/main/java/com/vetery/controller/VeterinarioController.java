package com.vetery.controller;

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

@RequestMapping("api/veterinario")
@RestController
public class VeterinarioController {

	@Autowired
	private VeterinarioService service;
	
	public VeterinarioController(VeterinarioService service) {
		super();
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<VeterinarioResponseDto> crearVeterinario (@Valid @RequestBody VeterinarioCreateDto dto){
		VeterinarioResponseDto resp = service.crearVeterinario(dto);
		return new ResponseEntity<VeterinarioResponseDto>(resp,HttpStatus.CREATED);
	}
	
	@GetMapping("/veterinaria/{id}")
	public ResponseEntity<List<VeterinarioResponseDto>> obtenerVeterinariosPorVeterinariaId (@PathVariable Long id){
		List<VeterinarioResponseDto> resp = service.obtenerVeterinariosPorVeterinariaId(id);
		return new ResponseEntity<List<VeterinarioResponseDto>>(resp,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<VeterinarioResponseDto> obtenerVeterinarioPorId (@PathVariable Long id){
		VeterinarioResponseDto resp = service.obtenerVeterinarioPorId(id);
		return new ResponseEntity<VeterinarioResponseDto>(resp,HttpStatus.ACCEPTED);
	}
	
	@PutMapping
	public ResponseEntity<VeterinarioResponseDto> editarVeterinario (@Valid @RequestBody VeterinarioUpdateDto dto){
		VeterinarioResponseDto resp = service.actualizarVeterinario(dto);
		return new ResponseEntity<VeterinarioResponseDto>(resp,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<VeterinarioResponseDto> eliminarVeterinario (@PathVariable Long id){
		VeterinarioResponseDto resp = service.eliminarVeterinario(id);
		return new ResponseEntity<VeterinarioResponseDto>(resp,HttpStatus.ACCEPTED);
	}
}
