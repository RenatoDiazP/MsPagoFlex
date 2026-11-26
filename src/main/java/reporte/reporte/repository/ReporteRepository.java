package reporte.reporte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import reporte.reporte.model.ReporteModel;

import java.util.List;
import java.util.Optional;

public interface ReporteRepository extends JpaRepository<ReporteModel, Long> {
    Optional<ReporteModel> findByNumero(String numero);
    List<ReporteModel> findByIdCompromiso(Integer idCompromiso);
    List<ReporteModel> findByIdAgente(Integer idAgente);
    List<ReporteModel> findByEstadoReporteId(Integer idEstadoReporte);
}