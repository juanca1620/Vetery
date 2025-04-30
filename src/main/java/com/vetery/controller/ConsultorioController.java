package com.vetery.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

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
@Tag(name = "Consultorios", description = "Operaciones para gestionar consultorios veterinarios")
public class ConsultorioController {

    @Autowired
    private final ConsultorioService consultorioService;

    public ConsultorioController(ConsultorioService consultorioService) {
        this.consultorioService = consultorioService;
    }

    @Operation(
            summary = "Crear consultorio",
            description = "Crea un consultorio nuevo asociado a una veterinaria específica."
    )
    @PostMapping("/veterinaria/{veterinariaId}")
    public ResponseEntity<ConsultorioResponseDto> crearConsultorio(
            @Valid @RequestBody ConsultorioCreateDto dto,
            @Parameter(description = "ID de la veterinaria") @PathVariable Long veterinariaId) {

        ConsultorioResponseDto response = consultorioService.crearConsultorio(dto, veterinariaId);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(
            summary = "Eliminar consultorio",
            description = "Elimina un consultorio por su ID."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<ConsultorioResponseDto> eliminarConsultorio(
            @Parameter(description = "ID del consultorio a eliminar") @PathVariable Long id) {

        ConsultorioResponseDto response = consultorioService.eliminarConsultorio(id);
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Obtener consultorio por ID",
            description = "Obtiene los detalles de un consultorio dado su ID."
    )
    @GetMapping("/{id}")
    public ResponseEntity<ConsultorioResponseDto> obtenerConsultorioPorId(
            @Parameter(description = "ID del consultorio") @PathVariable Long id) {

        ConsultorioResponseDto response = consultorioService.obtenerConsultorioPorId(id);
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Listar consultorios por veterinaria",
            description = "Devuelve todos los consultorios asociados a una veterinaria específica."
    )
    @GetMapping("/veterinaria/{veterinariaId}")
    public ResponseEntity<List<ConsultorioResponseDto>> obtenerConsultoriosPorVeterinaria(
            @Parameter(description = "ID de la veterinaria") @PathVariable Long veterinariaId) {

        List<ConsultorioResponseDto> response = consultorioService.obtenerConsultoriosPorVeterinaria(veterinariaId);
        return ResponseEntity.ok(response);
    }
}