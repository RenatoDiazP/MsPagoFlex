package com.pagoflex.compromisos.dto;

import lombok.Data;

@Data
public class UsuarioResponseDTO {
    private Long id;
    private String nombre;
    private boolean activo;
}
