package com.sulimann.cleanarch.infra.controllers.autor.criar;

import org.springframework.stereotype.Component;

import com.sulimann.cleanarch.core.usecases.autor.criar.ICriarAutorRepository;
import com.sulimann.cleanarch.infra.entities.AutorEntity;
import com.sulimann.cleanarch.infra.repositories.AutorRepository;

@Component
public class CriarAutorRepository implements ICriarAutorRepository<AutorEntity>{

  private final AutorRepository repository;

  public CriarAutorRepository(AutorRepository repository) {
    this.repository = repository;
  }

  @Override
  public AutorEntity salvar(AutorEntity entity) {
    return this.repository.save(entity);
  }

  @Override
  public boolean existsByEmail(String email) {
    return this.repository.existsByEmail(email);
  }

}
