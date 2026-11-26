package reporte.reporte.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reporte.reporte.dto.ReporteRequestDto;
import reporte.reporte.dto.ReporteResponseDto;
import reporte.reporte.model.EstadoReporteModel;
import reporte.reporte.model.MotivoReporteModel;
import reporte.reporte.model.ReporteModel;
import reporte.reporte.repository.EstadoReporteRepository;
import reporte.reporte.repository.MotivoReporteRepository;
import reporte.reporte.repository.ReporteRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReporteService {

    private final ReporteRepository reporteRepository;
    private final MotivoReporteRepository motivoRepository;
    private final EstadoReporteRepository estadoRepository;

    public List<ReporteResponseDto> listar() {
        return reporteRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    public ReporteResponseDto obtener(Long id) {
        ReporteModel reporte = reporteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reporte no encontrado"));
        return toResponse(reporte);
    }

    public List<ReporteResponseDto> listarPorCompromiso(Integer idCompromiso) {
        return reporteRepository.findByIdCompromiso(idCompromiso).stream()
                .map(this::toResponse)
                .toList();
    }

    public ReporteResponseDto registrar(ReporteRequestDto datos) {
        MotivoReporteModel motivo = motivoRepository.findById(datos.getIdMotivoReporte())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Motivo de reporte inválido"));

        if ("Otro".equalsIgnoreCase(motivo.getNombre())
                && (datos.getComentario() == null || datos.getComentario().isBlank())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El comentario es obligatorio cuando el motivo es Otro");
        }

        EstadoReporteModel estadoInicial = estadoRepository.findByNombreIgnoreCase("Abierto")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Estado Abierto no configurado"));

        String correlativo = String.format("REP-%04d", reporteRepository.count() + 1);

        ReporteModel reporte = ReporteModel.builder()
                .numero(correlativo)
                .idCompromiso(datos.getIdCompromiso())
                .motivoReporte(motivo)
                .comentario(datos.getComentario())
                .estadoReporte(estadoInicial)
                .idAgente(null)
                .build();

        return toResponse(reporteRepository.save(reporte));
    }

    public ReporteResponseDto tomarReporte(Long id, Integer idAgente) {
        ReporteModel reporte = reporteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reporte no encontrado"));

        EstadoReporteModel estadoRevision = estadoRepository.findByNombreIgnoreCase("En Revisión")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Estado En Revisión no configurado"));

        reporte.setIdAgente(idAgente);
        reporte.setFechaToma(LocalDateTime.now());
        reporte.setEstadoReporte(estadoRevision);

        return toResponse(reporteRepository.save(reporte));
    }

    public ReporteResponseDto resolverReporte(Long id, String respuesta) {
        if (respuesta == null || respuesta.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La respuesta es obligatoria para resolver el reporte (RN-23)");
        }

        ReporteModel reporte = reporteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reporte no encontrado"));

        EstadoReporteModel estadoResuelto = estadoRepository.findByNombreIgnoreCase("Resuelto")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Estado Resuelto no configurado"));

        reporte.setRespuesta(respuesta);
        reporte.setFechaResolucion(LocalDateTime.now());
        reporte.setEstadoReporte(estadoResuelto);

        return toResponse(reporteRepository.save(reporte));
    }

    public void eliminar(Long id) {
        if (!reporteRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reporte no encontrado");
        }
        reporteRepository.deleteById(id);
    }

    private ReporteResponseDto toResponse(ReporteModel r) {
        return ReporteResponseDto.builder()
                .id(r.getId())
                .numero(r.getNumero())
                .idCompromiso(r.getIdCompromiso())
                .idMotivoReporte(r.getMotivoReporte().getId())
                .nombreMotivo(r.getMotivoReporte().getNombre())
                .comentario(r.getComentario())
                .fechaCreacion(r.getFechaCreacion())
                .idEstadoReporte(r.getEstadoReporte().getId())
                .nombreEstado(r.getEstadoReporte().getNombre())
                .idAgente(r.getIdAgente())
                .fechaToma(r.getFechaToma())
                .respuesta(r.getRespuesta())
                .fechaResolucion(r.getFechaResolucion())
                .build();
    }
}