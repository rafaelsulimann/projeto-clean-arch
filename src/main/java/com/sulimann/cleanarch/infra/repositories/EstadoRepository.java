package com.sulimann.cleanarch.infra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sulimann.cleanarch.infra.entities.EstadoEntity;

public interface EstadoRepository extends JpaRepository<EstadoEntity, Long>{

  boolean existsByNome(String nome);

}
