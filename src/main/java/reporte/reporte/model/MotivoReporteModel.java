package reporte.reporte.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "motivos_reporte")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MotivoReporteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_motivo_reporte")
    private Integer id;

    @Column(name = "nombre", nullable = false, unique = true, length = 80)
    private String nombre;
}