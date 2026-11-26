package reporte.reporte.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReporteRequestDto {
    private Integer idCompromiso;
    private Integer idMotivoReporte;
    private String comentario;
    private Integer idEstadoReporte;
    private Integer idAgente;
    private String respuesta;
}