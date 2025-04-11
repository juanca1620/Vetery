package com.vetery.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

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
@Tag(name = "Disponibilidades", description = "Gestión de disponibilidades de los veterinarios")
public class DisponibilidadController {

    private final DisponibilidadService disponibilidadService;

    @Autowired
    public DisponibilidadController(DisponibilidadService disponibilidadService) {
        this.disponibilidadService = disponibilidadService;
    }

    @Operation(
            summary = "Crear disponibilidad",
            description = "Crea una nueva disponibilidad para un veterinario."
    )
    @PostMapping
    public ResponseEntity<DisponibilidadResponseDto> crearDisponibilidad(
            @Valid @RequestBody DisponibilidadCreateDto dto) {

        DisponibilidadResponseDto response = disponibilidadService.crearDisponibilidad(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(
            summary = "Eliminar disponibilidad",
            description = "Elimina una disponibilidad por su ID."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<DisponibilidadResponseDto> eliminarDisponibilidad(
            @Parameter(description = "ID de la disponibilidad a eliminar") @PathVariable Long id) {

        DisponibilidadResponseDto response = disponibilidadService.eliminarDisponibilidadPorId(id);
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Listar disponibilidades por veterinario",
            description = "Obtiene todas las disponibilidades asociadas a un veterinario."
    )
    @GetMapping("/veterinario/{veterinarioId}")
    public ResponseEntity<List<DisponibilidadResponseDto>> obtenerDisponibilidadesPorVeterinario(
            @Parameter(description = "ID del veterinario") @PathVariable Long veterinarioId) {

        List<DisponibilidadResponseDto> response = disponibilidadService.disponibilidadesVeterinarioId(veterinarioId);
        return ResponseEntity.ok(response);
    }
}