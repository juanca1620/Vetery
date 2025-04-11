package com.vetery.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vetery.dto.ConsultorioCreateDto;
import com.vetery.dto.ConsultorioResponseDto;
import com.vetery.service.ConsultorioService;

import java.util.List;

@RestController
@RequestMapping("/api/consultorios")
public class ConsultorioController {

	@Autowired
    private final ConsultorioService consultorioService;

    public ConsultorioController(ConsultorioService consultorioService) {
        this.consultorioService = consultorioService;
    }

    @PostMapping("/veterinaria/{veterinariaId}")
    public ResponseEntity<ConsultorioResponseDto> crearConsultorio(
            @Valid @RequestBody ConsultorioCreateDto dto,
            @PathVariable Long veterinariaId) {
        
        ConsultorioResponseDto response = consultorioService.crearConsultorio(dto, veterinariaId);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ConsultorioResponseDto> eliminarConsultorio(@PathVariable Long id) {
        ConsultorioResponseDto response = consultorioService.eliminarConsultorio(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultorioResponseDto> obtenerConsultorioPorId(@PathVariable Long id) {
        ConsultorioResponseDto response = consultorioService.obtenerConsultorioPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/veterinaria/{veterinariaId}")
    public ResponseEntity<List<ConsultorioResponseDto>> obtenerConsultoriosPorVeterinaria(
            @PathVariable Long veterinariaId) {
        
        List<ConsultorioResponseDto> response = consultorioService.obtenerConsultoriosPorVeterinaria(veterinariaId);
        return ResponseEntity.ok(response);
    }
}
