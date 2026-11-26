package reporte.reporte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import reporte.reporte.model.EstadoReporteModel;

import java.util.Optional;

public interface EstadoReporteRepository extends JpaRepository<EstadoReporteModel, Integer> {
    Optional<EstadoReporteModel> findByNombreIgnoreCase(String nombre);
}