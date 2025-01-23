package com.bandas.Bandas.repositories;

import com.bandas.Bandas.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

    Boolean existsByTitulo(String titulo);

    List<Album> findByBandaId(Long bandaId);

    Album findByIdAndBandaId(Long albumId, Long bandaId);

}
