package com.bandas.Bandas.controllers;

import com.bandas.Bandas.dto.AlbumDto;
import com.bandas.Bandas.dto.CancionDto;
import com.bandas.Bandas.services.CancionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("albumes/{albumId}/canciones")
public class CancionController {

    private final CancionService cancionService;

    public CancionController(CancionService cancionService) {
        this.cancionService = cancionService;
    }

    @PostMapping
    public ResponseEntity<CancionDto> saveCancion(@Valid @PathVariable Long albumId, @RequestBody CancionDto cancionDto){
        return new ResponseEntity<>(cancionService.save(albumId, cancionDto), HttpStatus.CREATED);
    }

    @GetMapping("todas")
    public ResponseEntity<List<CancionDto>> getCanciones(){
        return  new ResponseEntity<>(cancionService.getCanciones(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CancionDto>> getCancionesByAlbum(@PathVariable Long albumId){
        return new ResponseEntity<>(cancionService.findByAlbumId(albumId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CancionDto> getCancion(@PathVariable Long id){
        return new ResponseEntity<>(cancionService.getCancion(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CancionDto> updateBanda(@PathVariable Long id, @RequestBody CancionDto cancionDto){
        return new ResponseEntity<>(cancionService.update(id, cancionDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CancionDto> deleteBanda(@PathVariable Long id){
        return new ResponseEntity<>(cancionService.delete(id), HttpStatus.OK);
    }
}
