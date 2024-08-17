package com.nick.javeurios.repository;

import com.nick.javeurios.entity.CargaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CargaRepository extends JpaRepository<CargaEntity, Long> {
}
