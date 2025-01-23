package com.bandas.Bandas.repositories;

import com.bandas.Bandas.models.Banda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BandaRepository extends JpaRepository<Banda, Long> {

    Boolean existsByNombre(String nombre);

}
