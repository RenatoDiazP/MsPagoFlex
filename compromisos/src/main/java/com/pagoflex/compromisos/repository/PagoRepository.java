package com.pagoflex.compromisos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pagoflex.compromisos.model.Pago;

public interface PagoRepository extends JpaRepository<Pago, Long> {

}