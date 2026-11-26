package com.pagoflex.compromisos.mapper;

import org.mapstruct.Mapper;

import com.pagoflex.compromisos.dto.CompromisoRequestDTO;
import com.pagoflex.compromisos.dto.CompromisoResponseDTO;
import com.pagoflex.compromisos.model.Compromiso;

@Mapper(componentModel = "spring")
public interface CompromisoMapper {
    Compromiso toEntity(CompromisoRequestDTO dto);

    CompromisoResponseDTO toDTO(Compromiso entity);
}
