package com.pagoflex.compromisos.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PagoResponseDTO {
    private Long pagoId;

    private String numeroComprobante;

    private Long compromisoId;

    private LocalDateTime fechaHora;

    private int montoPagado;

    private Long canalId;

    private Long medioId;
}
