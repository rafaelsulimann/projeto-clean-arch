package com.sulimann.cleanarch.infra.controllers.livro.criar;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.sulimann.cleanarch.core.usecases.livro.criar.ICriarLivroCategoriaRepository;
import com.sulimann.cleanarch.infra.entities.CategoriaEntity;
import com.sulimann.cleanarch.infra.repositories.CategoriaRepository;

@Component
public class CriarLivroCategoriaRepository implements ICriarLivroCategoriaRepository<CategoriaEntity>{

  private final CategoriaRepository repository;

  public CriarLivroCategoriaRepository(CategoriaRepository repository) {
    this.repository = repository;
  }

  @Override
  public Optional<CategoriaEntity> findById(Long categoria) {
    return this.repository.findById(categoria);
  }

}
