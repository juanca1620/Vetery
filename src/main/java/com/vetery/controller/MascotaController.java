package com.vetery.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vetery.dto.MascotaCreateDto;
import com.vetery.dto.MascotaResponseDto;
import com.vetery.dto.MascotaUpdateDto;
import com.vetery.service.MascotaService;

import java.util.List;

@RestController
@RequestMapping("api/mascota")
@Tag(name = "Mascotas", description = "Operaciones relacionadas con las mascotas de los clientes")
public class MascotaController {

    @Autowired
    private final MascotaService service;

    public MascotaController(MascotaService service) {
        this.service = service;
    }

    @Operation(
            summary = "Crear mascota",
            description = "Registra una nueva mascota en el sistema."
    )
    @PostMapping
    public ResponseEntity<MascotaResponseDto> crearMascota(
            @Valid @RequestBody MascotaCreateDto dto) {
        MascotaResponseDto response = service.crearMascota(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(
            summary = "Obtener mascotas por cliente",
            description = "Obtiene todas las mascotas registradas para un cliente específico."
    )
    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<MascotaResponseDto>> obtenerMascotasPorClienteId(
            @Parameter(description = "ID del cliente") @PathVariable Long clienteId) {
        List<MascotaResponseDto> response = service.obtenerMascotasPorClienteId(clienteId);
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Actualizar mascota",
            description = "Actualiza los datos de una mascota existente."
    )
    @PutMapping
    public ResponseEntity<MascotaResponseDto> actualizarMascota(
            @Valid @RequestBody MascotaUpdateDto dto) {
        MascotaResponseDto response = service.actualizarMascota(dto);
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Eliminar mascota",
            description = "Elimina una mascota por su ID."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<MascotaResponseDto> eliminarMascota(
            @Parameter(description = "ID de la mascota a eliminar") @PathVariable Long id) {
        MascotaResponseDto response = service.eliminarMascota(id);
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Obtener mascota por ID",
            description = "Obtiene los detalles de una mascota mediante su ID."
    )
    @GetMapping("/{id}")
    public ResponseEntity<MascotaResponseDto> obtenerMascotaPorId(
            @Parameter(description = "ID de la mascota") @PathVariable Long id) {
        MascotaResponseDto response = service.obtenerMascotaPorId(id);
        return ResponseEntity.ok(response);
    }
}