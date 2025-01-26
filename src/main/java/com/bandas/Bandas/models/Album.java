package com.bandas.Bandas.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String imagen;

    @ManyToOne
    @JoinColumn(name = "banda_id", nullable = false)
    @JsonBackReference
    @JsonIgnore
    private Banda banda;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnore
    private List<Cancion> canciones;

    public Album(Long id, String titulo, String imagen, Banda banda, List<Cancion> canciones) {
        this.id = id;
        this.titulo = titulo;
        this.imagen = imagen;
        this.banda = banda;
        this.canciones = canciones;
    }

    public Album() {
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

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }
}
