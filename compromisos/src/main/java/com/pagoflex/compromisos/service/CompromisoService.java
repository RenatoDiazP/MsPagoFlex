package com.pagoflex.compromisos.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pagoflex.compromisos.client.EmpresaClient;
import com.pagoflex.compromisos.client.UsuarioClient;
import com.pagoflex.compromisos.dto.CompromisoRequestDTO;
import com.pagoflex.compromisos.dto.CompromisoResponseDTO;
import com.pagoflex.compromisos.dto.EmpresaResponseDTO;
import com.pagoflex.compromisos.dto.UsuarioResponseDTO;
import com.pagoflex.compromisos.mapper.CompromisoMapper;
import com.pagoflex.compromisos.model.Compromiso;
import com.pagoflex.compromisos.repository.CompromisoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompromisoService {
    private final CompromisoRepository repository;
    private final CompromisoMapper mapper;
    private final UsuarioClient usuarioClient;
    private final EmpresaClient empresaClient;

    // Get all
    public List<CompromisoResponseDTO> listarCompromisos(){
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    // Buscar x id
    public CompromisoResponseDTO buscarPorId(Long id){
        Compromiso compromiso = repository.findById(id).orElseThrow(() -> new RuntimeException("No existe compromiso con esa id"));

        return mapper.toDTO(compromiso);
    }

    // Crear compromiso
    public CompromisoResponseDTO crear(CompromisoRequestDTO dto){
        UsuarioResponseDTO usuario = usuarioClient.buscarUsuario(dto.getUsuarioId());

        if(usuario == null || !usuario.isActivo()){
            throw new RuntimeException("Usuario no valido");
        }

        EmpresaResponseDTO empresa = empresaClient.buscarEmpresa(dto.getEmpresaId());

        if(empresa == null || !empresa.isActivo()){
            throw new RuntimeException("Empresa no valida");
        }

        Compromiso compromiso = mapper.toEntity(dto);

        compromiso.setFechaRegistro(LocalDateTime.now());
        compromiso.setFechaCambioEstado(LocalDateTime.now());

        Compromiso guardado = repository.save(compromiso);

        return mapper.toDTO(guardado);
    }

    // Actualizar compromiso
    public CompromisoResponseDTO actualizar(Long id, CompromisoRequestDTO request){
        Compromiso compromiso = repository.findById(id).orElseThrow(() -> new RuntimeException("No existe un compromiso con esa id"));

        compromiso.setUsuarioId(request.getUsuarioId());
        compromiso.setEmpresaId(request.getEmpresaId());
        compromiso.setConcepto(request.getConcepto());
        compromiso.setNumeroCuotas(request.getNumeroCuotas());
        compromiso.setTotalCuotas(request.getTotalCuotas());
        compromiso.setMonto(request.getMonto());
        compromiso.setFechaVencimiento(request.getFechaVencimiento());
        compromiso.setEstadoId(request.getEstadoId());
        compromiso.setRecargoAplicado(request.getRecargoAplicado());
        compromiso.setEjecutivoId(request.getEjecutivoId());

        Compromiso actualizado = repository.save(compromiso);

        return mapper.toDTO(actualizado);
    }


    // Eliminar compromiso
    public void eliminar(Long id){
        Compromiso compromiso = repository.findById(id).orElseThrow(() -> new RuntimeException("No existe un compromiso con esa id"));

        repository.delete(compromiso);
    }

}
