package com.bandas.Bandas.repositories;

import com.bandas.Bandas.models.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CancionRepository extends JpaRepository<Cancion, Long> {

    Boolean existsByTitulo(String titulo);

    List<Cancion> findByAlbumId(Long albumId);

}
