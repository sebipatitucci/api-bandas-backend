package com.bandas.Bandas.services.impl;

import com.bandas.Bandas.dto.BandaDto;
import com.bandas.Bandas.exceptions.AppException;
import com.bandas.Bandas.mapper.BandaMapper;
import com.bandas.Bandas.models.Banda;
import com.bandas.Bandas.repositories.BandaRepository;
import com.bandas.Bandas.services.BandaService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BandaServiceImpl implements BandaService {

    private final BandaRepository bandaRepository;
    private final BandaMapper bandaMapper;

    public BandaServiceImpl(BandaRepository bandaRepository, BandaMapper bandaMapper) {
        this.bandaRepository = bandaRepository;
        this.bandaMapper = bandaMapper;
    }

    @Override
    public BandaDto save(BandaDto bandaDto) {
        Boolean existeBanda = bandaRepository.existsByNombre(bandaDto.getNombre());

        if (!existeBanda){
            Banda banda = bandaMapper.toBanda(bandaDto);
            return bandaMapper.toBandaDto(bandaRepository.save(banda));
        }else {
            throw new AppException("La banda ya existe", HttpStatus.CONFLICT);
        }
    }

    @Override
    public List<BandaDto> getBandas() {
        return bandaMapper.toBandaDtos(bandaRepository.findAll());
    }

    @Override
    public BandaDto getBanda(Long id) {
        Banda banda = bandaRepository.findById(id).orElseThrow(() -> new AppException("Banda no encontrada", HttpStatus.NOT_FOUND));
        return bandaMapper.toBandaDto(banda);
    }

    @Override
    public BandaDto update(Long id, BandaDto bandaDto) {
        Banda banda = bandaRepository.findById(id).orElseThrow(() -> new AppException("Banda no encontrada", HttpStatus.NOT_FOUND));
        bandaMapper.updateBanda(banda, bandaMapper.toBanda(bandaDto));
        return bandaMapper.toBandaDto(bandaRepository.save(banda));
    }

    @Override
    public BandaDto delete(Long id) {
        Banda banda = bandaRepository.findById(id).orElseThrow(() -> new AppException("Banda no encontrada", HttpStatus.NOT_FOUND));
        BandaDto bandaDto = bandaMapper.toBandaDto(banda);
        bandaRepository.deleteById(id);
        return bandaDto;
    }
}
