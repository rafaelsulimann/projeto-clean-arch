package com.sulimann.cleanarch.infra.controllers.pais.criar;

import org.springframework.stereotype.Component;

import com.sulimann.cleanarch.core.usecases.pais.criar.ICriarPaisRepository;
import com.sulimann.cleanarch.infra.entities.PaisEntity;
import com.sulimann.cleanarch.infra.repositories.PaisRepository;

@Component
public class CriarPaisRepository implements ICriarPaisRepository<PaisEntity>{

  private final PaisRepository repository;

  public CriarPaisRepository(PaisRepository repository) {
    this.repository = repository;
  }

  @Override
  public PaisEntity salvar(PaisEntity entity) {
    return this.repository.save(entity);
  }

  @Override
  public boolean existsByNome(String nome) {
    return this.repository.existsByNome(nome);
  }

}
