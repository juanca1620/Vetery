package com.vetery.controller;

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
public class MascotaController {

	@Autowired
    private final MascotaService service;

    public MascotaController(MascotaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MascotaResponseDto> crearMascota(@Valid @RequestBody MascotaCreateDto dto) {
        MascotaResponseDto response = service.crearMascota(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<MascotaResponseDto>> obtenerMascotasPorClienteId(@PathVariable Long clienteId) {
        List<MascotaResponseDto> response = service.obtenerMascotasPorClienteId(clienteId);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<MascotaResponseDto> actualizarMascota(@Valid @RequestBody MascotaUpdateDto dto) {
        MascotaResponseDto response = service.actualizarMascota(dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MascotaResponseDto> eliminarMascota(@PathVariable Long id) {
        MascotaResponseDto response = service.eliminarMascota(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MascotaResponseDto> obtenerMascotaPorId(@PathVariable Long id) {
        MascotaResponseDto response = service.obtenerMascotaPorId(id);
        return ResponseEntity.ok(response);
    }
}