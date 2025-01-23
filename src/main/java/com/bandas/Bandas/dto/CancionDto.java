package com.bandas.Bandas.dto;

import com.bandas.Bandas.models.Album;

public class CancionDto {
    private Long id;
    private String titulo;
    private Album album;

    public CancionDto() {
    }

    public CancionDto(Long id, String titulo, Album album) {
        this.id = id;
        this.titulo = titulo;
        this.album = album;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
