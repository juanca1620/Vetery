package com.vetery.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vetery.dto.ClienteCreateDto;
import com.vetery.dto.ClienteResponseDto;
import com.vetery.dto.ClienteUpdateDto;
import com.vetery.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("api/cliente")
@Tag(name = "Clientes", description = "Operaciones relacionadas con la gestión de clientes")
public class ClienteController {

    @Autowired
    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @Operation(
            summary = "Crear un nuevo cliente",
            description = "Crea un nuevo cliente usando los datos enviados en el cuerpo de la solicitud."
    )
    @PostMapping
    public ResponseEntity<ClienteResponseDto> crearCliente(@Valid @RequestBody ClienteCreateDto dto) {
        ClienteResponseDto response = service.crearCliente(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(
            summary = "Obtener clientes por veterinaria",
            description = "Devuelve una lista de clientes asociados a una veterinaria específica."
    )
    @GetMapping("/veterinaria/{id}")
    public ResponseEntity<List<ClienteResponseDto>> obtenerClientesPorVeterinariaId(
            @Parameter(description = "ID de la veterinaria") @PathVariable Long id) {
        List<ClienteResponseDto> response = service.obtenerClientesPorVeterinariaId(id);
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Actualizar cliente",
            description = "Actualiza la información de un cliente existente."
    )
    @PutMapping
    public ResponseEntity<ClienteResponseDto> actualizarCliente(@Valid @RequestBody ClienteUpdateDto dto) {
        ClienteResponseDto response = service.actualizarCliente(dto);
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Eliminar cliente",
            description = "Elimina un cliente existente usando su ID."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> eliminarCliente(
            @Parameter(description = "ID del cliente a eliminar") @PathVariable Long id) {
        ClienteResponseDto response = service.eliminarCliente(id);
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Obtener cliente por ID",
            description = "Devuelve los datos de un cliente según su ID."
    )
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> obtenerClientePorId(
            @Parameter(description = "ID del cliente a buscar") @PathVariable Long id) {
        ClienteResponseDto response = service.obtenerClientePorId(id);
        return ResponseEntity.ok(response);
    }
}
