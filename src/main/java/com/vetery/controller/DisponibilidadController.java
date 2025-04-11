package com.vetery.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vetery.dto.DisponibilidadCreateDto;
import com.vetery.dto.DisponibilidadResponseDto;
import com.vetery.service.DisponibilidadService;

import java.util.List;

@RestController
@RequestMapping("/api/disponibilidades")
public class DisponibilidadController {

    private final DisponibilidadService disponibilidadService;

    @Autowired
    public DisponibilidadController(DisponibilidadService disponibilidadService) {
        this.disponibilidadService = disponibilidadService;
    }

    @PostMapping
    public ResponseEntity<DisponibilidadResponseDto> crearDisponibilidad(
            @Valid @RequestBody DisponibilidadCreateDto dto) {
        
        DisponibilidadResponseDto response = disponibilidadService.crearDisponibilidad(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DisponibilidadResponseDto> eliminarDisponibilidad(
            @PathVariable Long id) {
        
        DisponibilidadResponseDto response = disponibilidadService.eliminarDisponibilidadPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/veterinario/{veterinarioId}")
    public ResponseEntity<List<DisponibilidadResponseDto>> obtenerDisponibilidadesPorVeterinario(
            @PathVariable Long veterinarioId) {
        
        List<DisponibilidadResponseDto> response = disponibilidadService.disponibilidadesVeterinarioId(veterinarioId);
        return ResponseEntity.ok(response);
    }
}