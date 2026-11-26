package com.pagoflex.compromisos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pagoflex.compromisos.model.Compromiso;
 
public interface CompromisoRepository extends JpaRepository<Compromiso, Long> {

}
