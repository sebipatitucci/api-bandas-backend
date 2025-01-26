package com.bandas.Bandas.controllers;

import com.bandas.Bandas.dto.AlbumDto;
import com.bandas.Bandas.services.AlbumService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bandas/{bandaId}/albumes")
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @PostMapping
    public ResponseEntity<AlbumDto> saveAlbum(@Valid @PathVariable Long bandaId, @RequestBody AlbumDto albumDto){
        return new ResponseEntity<>(albumService.save(bandaId, albumDto), HttpStatus.CREATED);
    }

    @GetMapping("todos")
    public ResponseEntity<List<AlbumDto>> getAlbumes(){
        return new ResponseEntity<>(albumService.getAlbumes(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AlbumDto>> getAlbumesByBanda(@PathVariable Long bandaId){
        return new ResponseEntity<>(albumService.findByBandaId(bandaId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlbumDto> findByIdAndBandaId(@PathVariable Long id, @PathVariable Long bandaId){
        return new ResponseEntity<>(albumService.findByIdAndBandaId(id, bandaId), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlbumDto> updateAlbum(@PathVariable Long bandaId, @PathVariable Long id, @RequestBody AlbumDto albumDto){
        return new ResponseEntity<>(albumService.update(bandaId, id, albumDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AlbumDto> deleteAlbum(@PathVariable Long id){
        return new ResponseEntity<>(albumService.delete(id), HttpStatus.OK);
    }

}
