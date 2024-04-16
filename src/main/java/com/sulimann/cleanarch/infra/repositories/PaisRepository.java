package com.sulimann.cleanarch.infra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sulimann.cleanarch.infra.entities.PaisEntity;

public interface PaisRepository extends JpaRepository<PaisEntity, Long>{

  boolean existsByNome(String nome);

}
