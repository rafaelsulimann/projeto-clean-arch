package com.sulimann.cleanarch.infra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sulimann.cleanarch.infra.entities.LivroEntity;

public interface LivroRepository extends JpaRepository<LivroEntity, Long>{

  boolean existsByTitulo(String titulo);
  boolean existsByIsbn(Long isbn);

}
