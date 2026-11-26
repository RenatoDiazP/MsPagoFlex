package com.pagoflex.compromisos.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.pagoflex.compromisos.dto.UsuarioResponseDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UsuarioClient {
    private final WebClient webClient;

    public UsuarioResponseDTO buscarUsuario(Long id){
        return webClient.get()
            .uri("http://usuarios-ms/usuarios{id}", id)
            .retrieve()
            .bodyToMono(UsuarioResponseDTO.class)
            .block();
    }
}
