package com.pagoflex.compromisos.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "pagos")
@AllArgsConstructor
@NoArgsConstructor
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago", nullable = false)
    private Long pagoId;

    @Column(name = "numero_comprobante", nullable = false, unique = true)
    private String numeroComprobante;

    @OneToOne
    @JoinColumn(name = "id_compromiso", nullable = false, unique = true)
    private Compromiso compromiso;

    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

    @Column(name = "monto_pagado", nullable = false)
    private int montoPagado;

    @Column(name = "id_canal", nullable = false)
    private Long canalId;

    @Column(name = "id_medio", nullable = false)
    private Long medioId;
}