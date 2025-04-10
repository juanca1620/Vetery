package com.vetery.controller;

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
public class VeterinariaController {

	@Autowired
	private VeterinariaService service;

	public VeterinariaController(VeterinariaService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/register")
	public ResponseEntity<VeterinariaResponseDto> register (@Valid @RequestBody VeterinariaCreateDto dto){
		
		VeterinariaResponseDto resp = service.registrarVeterinaria(dto);
		
		return new ResponseEntity<VeterinariaResponseDto>(resp,HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<VeterinariaResponseDto> login (@Valid @RequestBody LoginDto dto){
		VeterinariaResponseDto resp = service.login(dto);
		
		return new ResponseEntity<VeterinariaResponseDto>(resp,HttpStatus.CREATED);
	}
}
