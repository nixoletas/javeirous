package com.nick.javeurios.repository;

import com.nick.javeurios.entity.Carga;
import com.nick.javeurios.entity.Cautela;
import com.nick.javeurios.entity.Militar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CautelaRepository extends JpaRepository<Cautela, Long> {

    Optional<Cautela> findByMilitarAndCarga(Militar militar, Carga carga);
}
