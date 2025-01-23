package com.bandas.Bandas.services.impl;

import com.bandas.Bandas.dto.AlbumDto;
import com.bandas.Bandas.exceptions.AppException;
import com.bandas.Bandas.mapper.AlbumMapper;
import com.bandas.Bandas.models.Album;
import com.bandas.Bandas.models.Banda;
import com.bandas.Bandas.repositories.AlbumRepository;
import com.bandas.Bandas.repositories.BandaRepository;
import com.bandas.Bandas.services.AlbumService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final AlbumMapper albumMapper;
    private final BandaRepository bandaRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository, AlbumMapper albumMapper, BandaRepository bandaRepository) {
        this.albumRepository = albumRepository;
        this.albumMapper = albumMapper;
        this.bandaRepository = bandaRepository;
    }

    @Override
    public AlbumDto save(Long bandaId, AlbumDto albumDto) {
        Boolean existeAlbum = albumRepository.existsByTitulo(albumDto.getTitulo());
        Boolean existeBanda = bandaRepository.existsById(bandaId);

        if (!existeAlbum && !existeBanda){
            Banda banda = bandaRepository.findById(bandaId).orElseThrow(() -> new AppException("Banda no encontrada", HttpStatus.NOT_FOUND));
            Album album = albumMapper.toAlbum(albumDto);
            album.setBanda(banda);

            return albumMapper.toAlbumDto(albumRepository.save(album));
        }else {
            throw new AppException("El album ya existe", HttpStatus.CONFLICT);
        }
    }

    @Override
    public List<AlbumDto> getAlbumes() {
        return albumMapper.toAlbumDtos(albumRepository.findAll());
    }

    @Override
    public List<AlbumDto> findByBandaId(Long bandaId) {
        return albumMapper.toAlbumDtos(albumRepository.findByBandaId(bandaId));
    }

    @Override
    public AlbumDto getAlbum(Long id) {
        Album album = albumRepository.findById(id).orElseThrow(() -> new AppException("Album no encontrado", HttpStatus.NOT_FOUND));
        return albumMapper.toAlbumDto(album);
    }

    @Override
    public AlbumDto findByIdAndBandaId(Long albumId, Long bandaId) {
        Album album = albumRepository.findById(albumId).orElseThrow(() -> new AppException("Album no encontrado", HttpStatus.NOT_FOUND));
        Banda banda = bandaRepository.findById(bandaId).orElseThrow(() -> new AppException("Banda no encontrada", HttpStatus.NOT_FOUND));
        if (banda.getId().equals(album.getBanda().getId())){
            return albumMapper.toAlbumDto(albumRepository.findByIdAndBandaId(albumId, bandaId));
        }
    throw new AppException("La banda no ha producido ese album", HttpStatus.NOT_FOUND);
    }

    @Override
    public AlbumDto update(Long id, AlbumDto albumDto) {
        Album album = albumRepository.findById(id).orElseThrow(() -> new AppException("Album no encontrado", HttpStatus.NOT_FOUND));
        albumMapper.updateAlbum(album, albumMapper.toAlbum(albumDto));
        return albumMapper.toAlbumDto(albumRepository.save(album));
    }

    @Override
    public AlbumDto delete(Long id) {
        Album album = albumRepository.findById(id).orElseThrow(() -> new AppException("Album no encontrado", HttpStatus.NOT_FOUND));
        AlbumDto albumDto = albumMapper.toAlbumDto(album);
        albumRepository.deleteById(id);
        return albumDto;
    }
}
