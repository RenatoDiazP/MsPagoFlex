package com.pagoflex.compromisos.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data 
public class AnulacionResponseDTO {
    private Long compromisoId;

    private Long ejecutivoId;

    private Long motivoId;

    private String comentario;

    private LocalDateTime fecha;
}
