package com.vetery.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vetery.service.EmailService;

import java.util.Map;

@RestController
@RequestMapping("api/email")
@Tag(name = "Correo", description = "Operaciones para el envío de correos electrónicos")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Operation(
            summary = "Enviar correo",
            description = "Envía un correo electrónico a la dirección especificada."
    )
    @PostMapping("/")
    public ResponseEntity<Map<String, String>> enviarCorreo(
            @Parameter(description = "Correo electrónico del destinatario") 
            @RequestParam String to) {

        emailService.sendEmail(to);
        return ResponseEntity.ok(Map.of("status", "correo enviado a " + to + " con éxito"));
    }
}