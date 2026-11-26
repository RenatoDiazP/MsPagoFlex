package reporte.reporte.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReporteResponseDto {
    private Long id;
    private String numero;
    private Integer idCompromiso;
    private Integer idMotivoReporte;
    private String nombreMotivo;
    private String comentario;
    private LocalDateTime fechaCreacion;
    private Integer idEstadoReporte;
    private String nombreEstado;
    private Integer idAgente;
    private LocalDateTime fechaToma;
    private String respuesta;
    private LocalDateTime fechaResolucion;
}