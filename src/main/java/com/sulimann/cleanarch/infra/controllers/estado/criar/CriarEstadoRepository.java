package com.sulimann.cleanarch.infra.controllers.estado.criar;

import org.springframework.stereotype.Component;

import com.sulimann.cleanarch.core.usecases.estado.criar.ICriarEstadoRepository;
import com.sulimann.cleanarch.infra.entities.EstadoEntity;
import com.sulimann.cleanarch.infra.repositories.EstadoRepository;

@Component
public class CriarEstadoRepository implements ICriarEstadoRepository<EstadoEntity>{

  private final EstadoRepository repository;

  public CriarEstadoRepository(EstadoRepository repository) {
    this.repository = repository;
  }

  @Override
  public EstadoEntity salvar(EstadoEntity estado) {
    return this.repository.save(estado);
  }

  @Override
  public boolean existsByNome(String nome) {
    return this.repository.existsByNome(nome);
  }

}
