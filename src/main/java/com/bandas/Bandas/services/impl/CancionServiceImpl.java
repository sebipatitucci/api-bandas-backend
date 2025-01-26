package com.bandas.Bandas.services.impl;

import com.bandas.Bandas.dto.CancionDto;
import com.bandas.Bandas.exceptions.AppException;
import com.bandas.Bandas.mapper.CancionMapper;
import com.bandas.Bandas.models.Album;
import com.bandas.Bandas.models.Banda;
import com.bandas.Bandas.models.Cancion;
import com.bandas.Bandas.repositories.AlbumRepository;
import com.bandas.Bandas.repositories.CancionRepository;
import com.bandas.Bandas.services.CancionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CancionServiceImpl implements CancionService {

    private final CancionRepository cancionRepository;
    private final CancionMapper cancionMapper;
    private final AlbumRepository albumRepository;

    public CancionServiceImpl(CancionRepository cancionRepository, CancionMapper cancionMapper, AlbumRepository albumRepository) {
        this.cancionRepository = cancionRepository;
        this.cancionMapper = cancionMapper;
        this.albumRepository = albumRepository;
    }

    @Override
    public CancionDto save(Long albumId, CancionDto cancionDto) {
        Boolean existeCancion = cancionRepository.existsByTitulo(cancionDto.getTitulo());

        if (!existeCancion){
            Cancion cancion = cancionMapper.toCancion(cancionDto);
            Album album = albumRepository.findById(albumId).orElseThrow(() -> new AppException("Album no encontrado", HttpStatus.NOT_FOUND));
            cancion.setAlbum(album);

            return cancionMapper.toCancionDto(cancionRepository.save(cancion));
        }else {
            throw new AppException("La cancion ya existe", HttpStatus.CONFLICT);
        }
    }

    @Override
    public List<CancionDto> getCanciones() {
        return cancionMapper.toCancionDtos(cancionRepository.findAll());
    }

    @Override
    public List<CancionDto> findByAlbumId(Long albumId) {
        return cancionMapper.toCancionDtos(cancionRepository.findByAlbumId(albumId));
    }

    @Override
    public CancionDto getCancion(Long id) {
        Cancion cancion = cancionRepository.findById(id).orElseThrow(() -> new AppException("Cancion no encontrada", HttpStatus.NOT_FOUND));
        return cancionMapper.toCancionDto(cancion);
    }

    @Override
    public CancionDto update(Long id, CancionDto cancionDto) {
        Cancion cancion = cancionRepository.findById(id).orElseThrow(() -> new AppException("Cancion no encontrada", HttpStatus.NOT_FOUND));

        cancion.setTitulo(cancionDto.getTitulo());

        cancionMapper.updateCancion(cancion, cancionMapper.toCancion(cancionDto));
        return cancionMapper.toCancionDto(cancionRepository.save(cancion));
    }

    @Override
    public CancionDto delete(Long id) {
        Cancion cancion = cancionRepository.findById(id).orElseThrow(() -> new AppException("Cancion no encontrada", HttpStatus.NOT_FOUND));
        CancionDto cancionDto = cancionMapper.toCancionDto(cancion);
        cancionRepository.deleteById(id);
        return cancionDto;
    }
}
