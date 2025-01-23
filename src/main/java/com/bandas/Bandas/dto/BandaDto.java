package com.bandas.Bandas.dto;

import com.bandas.Bandas.models.Album;

import java.util.List;

public class BandaDto {
    private Long id;
    private String nombre;
    private List<Album> albumes;

    public BandaDto() {
    }

    public BandaDto(Long id, String nombre, List<Album> albumes) {
        this.id = id;
        this.nombre = nombre;
        this.albumes = albumes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Album> getAlbumes() {
        return albumes;
    }

    public void setAlbumes(List<Album> albumes) {
        this.albumes = albumes;
    }
}
