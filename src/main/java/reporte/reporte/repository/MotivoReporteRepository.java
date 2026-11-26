package reporte.reporte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import reporte.reporte.model.MotivoReporteModel;

import java.util.Optional;

public interface MotivoReporteRepository extends JpaRepository<MotivoReporteModel, Integer> {
    Optional<MotivoReporteModel> findByNombreIgnoreCase(String nombre);
}