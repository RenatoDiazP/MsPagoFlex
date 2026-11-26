package com.pagoflex.compromisos.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "compromisos")
@AllArgsConstructor
@NoArgsConstructor
public class Compromiso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compromiso", nullable = false)
    private Long compromisoId;

    @Column(name = "folio", nullable = false)
    private String folio;

    @Column(name = "id_usuario_final", nullable = false)
    private Long usuarioId;

    @Column(name = "id_empresa", nullable = false)
    private Long empresaId;

    @Column(name = "concepto", nullable = false)
    private String concepto;

    @Column(name = "numero_cuota", nullable = true)
    private int numeroCuotas;

    @Column(name = "total_cuotas", nullable = true)
    private int totalCuotas;

    @Column(name = "monto", nullable = false)
    private int monto;

    @Column(name = "fecha_vencimiento", nullable = false)
    private LocalDate fechaVencimiento;

    @Column(name = "id_estado_compromiso", nullable = false)
    private Long estadoId;

    @Column(name = "recargo_aplicado", nullable = false)
    private int recargoAplicado;

    @Column(name = "fecha_cambio_estado", nullable = false)
    private LocalDateTime fechaCambioEstado;

    @Column(name = "id_ejecutivo_registro", nullable = true)
    private Long ejecutivoId;
    
    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;
}