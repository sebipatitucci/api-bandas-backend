package com.bandas.Bandas.services;

import com.bandas.Bandas.dto.AlbumDto;

import java.util.List;

public interface AlbumService {

    public AlbumDto save(Long bandaId, AlbumDto albumDto);

    public List<AlbumDto> getAlbumes();

    public List<AlbumDto> findByBandaId(Long bandaId);

    public AlbumDto getAlbum(Long id);

    public AlbumDto findByIdAndBandaId(Long albumId, Long bandaId);

    public AlbumDto update(Long bandaId, Long id, AlbumDto albumDto);

    public AlbumDto delete(Long id);

}
