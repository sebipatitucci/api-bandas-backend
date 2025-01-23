package com.bandas.Bandas.controllers;

import com.bandas.Bandas.dto.BandaDto;
import com.bandas.Bandas.models.Banda;
import com.bandas.Bandas.services.BandaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bandas")
public class BandaController {

    private final BandaService bandaService;

    public BandaController(BandaService bandaService) {
        this.bandaService = bandaService;
    }

    @PostMapping
    public ResponseEntity<BandaDto> saveBanda(@Valid @RequestBody BandaDto bandaDto){
        return new ResponseEntity<>(bandaService.save(bandaDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BandaDto>> getBandas(){
        return  new ResponseEntity<>(bandaService.getBandas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BandaDto> getBanda(@PathVariable Long id){
        return new ResponseEntity<>(bandaService.getBanda(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BandaDto> updateBanda(@PathVariable Long id, @RequestBody BandaDto bandaDto){
        return new ResponseEntity<>(bandaService.update(id, bandaDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BandaDto> deleteBanda(@PathVariable Long id){
        return  new ResponseEntity<>(bandaService.delete(id), HttpStatus.OK);
    }

}
