package reporte.reporte.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reporte.reporte.model.EstadoReporteModel;
import reporte.reporte.model.MotivoReporteModel;
import reporte.reporte.repository.EstadoReporteRepository;
import reporte.reporte.repository.MotivoReporteRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReporteDataLoader implements CommandLineRunner {

    private final MotivoReporteRepository motivoRepository;
    private final EstadoReporteRepository estadoRepository;

    @Override
    public void run(String... args) {
        if (motivoRepository.count() == 0) {
            motivoRepository.saveAll(List.of(
                    MotivoReporteModel.builder().nombre("Cobro indebido").build(),
                    MotivoReporteModel.builder().nombre("Pago no reflejado").build(),
                    MotivoReporteModel.builder().nombre("Problema con cuota").build(),
                    MotivoReporteModel.builder().nombre("Otro").build()
            ));
        }

        if (estadoRepository.count() == 0) {
            estadoRepository.saveAll(List.of(
                    EstadoReporteModel.builder().nombre("Abierto").build(),
                    EstadoReporteModel.builder().nombre("En Revisión").build(),
                    EstadoReporteModel.builder().nombre("Resuelto").build()
            ));
        }
    }
}