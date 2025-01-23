package com.bandas.Bandas.mapper;

import com.bandas.Bandas.dto.CancionDto;
import com.bandas.Bandas.models.Cancion;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CancionMapper {

    Cancion toCancion(CancionDto cancionDto);

    CancionDto toCancionDto(Cancion cancion);

    List<CancionDto> toCancionDtos(List<Cancion> anciones);

    void updateCancion(@MappingTarget Cancion cancion, Cancion cancionDto);

}
