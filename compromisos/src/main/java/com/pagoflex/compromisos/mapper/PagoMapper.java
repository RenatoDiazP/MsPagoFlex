package com.pagoflex.compromisos.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.pagoflex.compromisos.dto.PagoRequestDTO;
import com.pagoflex.compromisos.dto.PagoResponseDTO;
import com.pagoflex.compromisos.model.Pago;

@Mapper(componentModel = "spring")
public interface PagoMapper {

    @Mapping(target = "compromiso", ignore = true)
    Pago toEntity(PagoRequestDTO dto);

    @Mapping(source = "compromiso.compromisoId", target = "compromisoId")
    PagoResponseDTO toDTO(Pago pago);
}
