package com.bandas.Bandas.mapper;

import com.bandas.Bandas.dto.BandaDto;
import com.bandas.Bandas.models.Banda;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BandaMapper {

    Banda toBanda(BandaDto bandaDto);

    BandaDto toBandaDto(Banda banda);

    List<BandaDto> toBandaDtos(List<Banda> bandas);

    void updateBanda(@MappingTarget Banda banda, Banda bandaDto);

}
