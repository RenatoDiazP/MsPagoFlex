package com.pagoflex.compromisos.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.pagoflex.compromisos.dto.AnulacionRequestDTO;
import com.pagoflex.compromisos.dto.AnulacionResponseDTO;
import com.pagoflex.compromisos.model.Anulacion;

@Mapper(componentModel = "spring")
public interface AnulacionMapper {
    @Mapping(source = "compromiso.compromisoId", target = "compromisoId")
    AnulacionResponseDTO toDTO(Anulacion anulacion);

    @Mapping(target = "compromiso", ignore = true)
    Anulacion toEntity(AnulacionRequestDTO dto);
}
