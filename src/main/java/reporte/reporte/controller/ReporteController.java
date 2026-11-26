package reporte.reporte.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reporte.reporte.dto.ReporteRequestDto;
import reporte.reporte.dto.ReporteResponseDto;
import reporte.reporte.model.EstadoReporteModel;
import reporte.reporte.model.MotivoReporteModel;
import reporte.reporte.repository.EstadoReporteRepository;
import reporte.reporte.repository.MotivoReporteRepository;
import reporte.reporte.service.ReporteService;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
@RequiredArgsConstructor
public class ReporteController {

    private final ReporteService reporteService;
    private final MotivoReporteRepository motivoRepository;
    private final EstadoReporteRepository estadoRepository;

    @GetMapping
    public List<ReporteResponseDto> listar() {
        return reporteService.listar();
    }

    @GetMapping("/{id}")
    public ReporteResponseDto obtener(@PathVariable Long id) {
        return reporteService.obtener(id);
    }

    @GetMapping("/compromiso/{idCompromiso}")
    public List<ReporteResponseDto> listarPorCompromiso(@PathVariable Integer idCompromiso) {
        return reporteService.listarPorCompromiso(idCompromiso);
    }

    @GetMapping("/motivos")
    public List<MotivoReporteModel> listarMotivos() {
        return motivoRepository.findAll();
    }

    @GetMapping("/estados")
    public List<EstadoReporteModel> listarEstados() {
        return estadoRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReporteResponseDto registrar(@RequestBody ReporteRequestDto datos) {
        return reporteService.registrar(datos);
    }

    @PatchMapping("/{id}/tomar")
    public ReporteResponseDto tomarReporte(@PathVariable Long id, @RequestParam Integer idAgente) {
        return reporteService.tomarReporte(id, idAgente);
    }

    @PatchMapping("/{id}/resolver")
    public ReporteResponseDto resolverReporte(@PathVariable Long id, @RequestBody String respuesta) {
        return reporteService.resolverReporte(id, respuesta);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        reporteService.eliminar(id);
    }
}