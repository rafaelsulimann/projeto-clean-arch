package com.sulimann.cleanarch.infra.controllers.livros.criar;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.sulimann.cleanarch.core.usecases.livro.criar.ICriarLivroAutorRepository;
import com.sulimann.cleanarch.infra.entities.AutorEntity;
import com.sulimann.cleanarch.infra.repositories.AutorRepository;

@Component
public class CriarLivroAutorRepository implements ICriarLivroAutorRepository<AutorEntity>{

  private final AutorRepository repository;

  public CriarLivroAutorRepository(AutorRepository repository) {
    this.repository = repository;
  }

  @Override
  public Optional<AutorEntity> findById(Long autor) {
    return this.repository.findById(autor);
  }

}
