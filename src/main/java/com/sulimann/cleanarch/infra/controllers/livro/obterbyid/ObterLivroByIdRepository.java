package com.sulimann.cleanarch.infra.controllers.livro.obterbyid;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.sulimann.cleanarch.core.usecases.livro.obterbyid.IObterLivroByIdRepository;
import com.sulimann.cleanarch.infra.entities.LivroEntity;
import com.sulimann.cleanarch.infra.repositories.LivroRepository;

@Component
public class ObterLivroByIdRepository implements IObterLivroByIdRepository<LivroEntity>{

  private final LivroRepository repository;

  public ObterLivroByIdRepository(LivroRepository repository) {
    this.repository = repository;
  }

  @Override
  public Optional<LivroEntity> findById(Long id) {
    return this.repository.findById(id);
  }

}
