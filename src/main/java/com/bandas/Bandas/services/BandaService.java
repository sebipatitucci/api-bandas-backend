package com.bandas.Bandas.services;

import com.bandas.Bandas.dto.BandaDto;

import java.util.List;

public interface BandaService {

    public BandaDto save(BandaDto bandaDto);

    public List<BandaDto> getBandas();

    public BandaDto getBanda(Long id);

    public BandaDto update(Long id, BandaDto bandaDto);

    public BandaDto delete(Long id);

}
