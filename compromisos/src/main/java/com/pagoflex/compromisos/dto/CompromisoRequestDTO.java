package com.pagoflex.compromisos.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CompromisoRequestDTO {
    private Long usuarioId;

    private Long empresaId;

    private String concepto;

    private int numeroCuotas;

    private int totalCuotas;

    private int monto;

    private LocalDate fechaVencimiento;

    private Long estadoId;

    private int recargoAplicado;

    private Long ejecutivoId;
}
