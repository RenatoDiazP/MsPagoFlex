package com.pagoflex.compromisos.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "anulaciones")
@AllArgsConstructor
@NoArgsConstructor
public class Anulacion {
    @Id
    @Column(name = "id_compromiso")
    private Long compromisoId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_compromiso")
    private Compromiso compromiso;

    @Column(name = "id_ejecutivo", nullable = false)
    private Long ejecutivoId;

    @Column(name = "id_motivo_anulacion", nullable = false)
    private Long motivoId;

    @Column(name = "comentario", nullable = true)
    private String comentario;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;
}