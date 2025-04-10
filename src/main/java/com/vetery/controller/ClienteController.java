package com.vetery.controller;

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
public class ClienteController {

	@Autowired
    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDto> crearCliente(@Valid @RequestBody ClienteCreateDto dto) {
        ClienteResponseDto response = service.crearCliente(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/veterinaria/{id}")
    public ResponseEntity<List<ClienteResponseDto>> obtenerClientesPorVeterinariaId(@PathVariable Long id) {
        List<ClienteResponseDto> response = service.obtenerClientesPorVeterinariaId(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<ClienteResponseDto> actualizarCliente(@Valid @RequestBody ClienteUpdateDto dto) {
        ClienteResponseDto response = service.actualizarCliente(dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> eliminarCliente(@PathVariable Long id) {
        ClienteResponseDto response = service.eliminarCliente(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> obtenerClientePorId(@PathVariable Long id) {
        ClienteResponseDto response = service.obtenerClientePorId(id);
        return ResponseEntity.ok(response);
    }
}