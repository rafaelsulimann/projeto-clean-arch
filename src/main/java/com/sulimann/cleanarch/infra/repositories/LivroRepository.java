package com.sulimann.cleanarch.infra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sulimann.cleanarch.infra.entities.LivroEntity;

public interface LivroRepository extends JpaRepository<LivroEntity, Long>, JpaSpecificationExecutor<LivroEntity>{

  boolean existsByTitulo(String titulo);
  boolean existsByIsbn(Long isbn);

}
