package com.vetery.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class HorarioCreateDto {

    @NotNull(message = "La fecha y hora de inicio no puede estar vacía")
    @FutureOrPresent(message = "La fecha de inicio debe ser en el presente o futuro")
    private LocalDateTime fechaInicio;
    
    @NotNull(message = "La fecha y hora de fin no puede estar vacía")
    @Future(message = "La fecha de fin debe ser en el futuro")
    private LocalDateTime fechaFin;

    @AssertTrue(message = "La fecha de fin debe ser posterior a la fecha de inicio")
    public boolean isFechaFinValid() {
        return fechaFin.isAfter(fechaInicio);
    }
}