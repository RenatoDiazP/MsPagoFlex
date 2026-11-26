package com.pagoflex.compromisos.dto;

import lombok.Data;

@Data
public class AnulacionRequestDTO {
    private Long compromisoId;

    private Long ejecutivoId;

    private Long motivoId;

    private String comentario;
}
