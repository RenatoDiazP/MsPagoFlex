package com.pagoflex.compromisos.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pagoflex.compromisos.dto.AnulacionRequestDTO;
import com.pagoflex.compromisos.dto.AnulacionResponseDTO;
import com.pagoflex.compromisos.mapper.AnulacionMapper;
import com.pagoflex.compromisos.model.Anulacion;
import com.pagoflex.compromisos.model.Compromiso;
import com.pagoflex.compromisos.repository.AnulacionRepository;
import com.pagoflex.compromisos.repository.CompromisoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnulacionService {
    private final AnulacionRepository repository;
    private final AnulacionMapper mapper;
    private final CompromisoRepository compromisoRepository;

    public List<AnulacionResponseDTO> listar(){
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    public AnulacionResponseDTO buscarPorId(Long compromisoId){
        Anulacion anulacion = repository.findById(compromisoId).orElseThrow(() -> new RuntimeException("No existe anulacion para el compromiso: " + compromisoId));

        return mapper.toDTO(anulacion);
    }

    public AnulacionResponseDTO crear(AnulacionRequestDTO request){
        Compromiso compromiso = compromisoRepository.findById(request.getCompromisoId()).orElseThrow(() -> new RuntimeException("No existe ese compromiso."));

        Anulacion anulacion = mapper.toEntity(request);

        anulacion.setCompromiso(compromiso);

        anulacion.setFecha(LocalDateTime.now());

        Anulacion guardada = repository.save(anulacion);

        return mapper.toDTO(guardada);
    }

    public void eliminar(Long compromisoId){
        if(!repository.existsById(compromisoId)){
            throw new RuntimeException("No existe anulacion de ese compromiso.");
        }
    }
}