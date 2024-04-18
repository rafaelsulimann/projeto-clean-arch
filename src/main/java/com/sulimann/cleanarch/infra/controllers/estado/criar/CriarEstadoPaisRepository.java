package com.sulimann.cleanarch.infra.controllers.estado.criar;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.sulimann.cleanarch.core.usecases.estado.criar.ICriarEstadoPaisRepository;
import com.sulimann.cleanarch.infra.entities.PaisEntity;
import com.sulimann.cleanarch.infra.repositories.PaisRepository;

@Component
public class CriarEstadoPaisRepository implements ICriarEstadoPaisRepository<PaisEntity>{

  private final PaisRepository repository;

  public CriarEstadoPaisRepository(PaisRepository repository) {
    this.repository = repository;
  }

  @Override
  public Optional<PaisEntity> findById(Long paisId) {
    return this.repository.findById(paisId);
  }

}
