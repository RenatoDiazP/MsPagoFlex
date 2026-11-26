package com.pagoflex.compromisos.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data 
public class CompromisoResponseDTO {

    private Long compromisoId;

    private String folio;

    private Long usuarioId;

    private Long empresaId;

    private String concepto;

    private int monto;

    private LocalDate fechaVencimiento;

    private Long estadoId;

    private LocalDateTime fechaRegistro;
}