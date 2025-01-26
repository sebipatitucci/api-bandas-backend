package com.bandas.Bandas.dto;

import com.bandas.Bandas.models.Banda;
import com.bandas.Bandas.models.Cancion;

import java.util.List;

public class AlbumDto {
    private Long id;
    private String titulo;
    private String imagen;
    private Banda banda;
    private List<Cancion> canciones;

    public AlbumDto(Long id, String titulo, String imagen, Banda banda, List<Cancion> canciones) {
        this.id = id;
        this.titulo = titulo;
        this.imagen = imagen;
        this.banda = banda;
        this.canciones = canciones;
    }

    public AlbumDto() {
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }
}
