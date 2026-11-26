package com.pagoflex.compromisos.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.pagoflex.compromisos.dto.EmpresaResponseDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EmpresaClient {
    private final WebClient webClient;

    public EmpresaResponseDTO buscarEmpresa(Long id){
        return webClient.get()
            .uri("http://empresa-ms/empresas/{id}", id)
            .retrieve()
            .bodyToMono(EmpresaResponseDTO.class)
            .block();
    }
}
