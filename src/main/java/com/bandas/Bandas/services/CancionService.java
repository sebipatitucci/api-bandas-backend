package com.bandas.Bandas.services;

import com.bandas.Bandas.dto.AlbumDto;
import com.bandas.Bandas.dto.CancionDto;

import java.util.List;

public interface CancionService {

    public CancionDto save(Long albumId, CancionDto cancionDto);

    public List<CancionDto> getCanciones();

    public List<CancionDto> findByAlbumId(Long albumId);

    public CancionDto getCancion(Long id);

    public CancionDto update(Long id, CancionDto cancionDto);

    public CancionDto delete(Long id);


}
