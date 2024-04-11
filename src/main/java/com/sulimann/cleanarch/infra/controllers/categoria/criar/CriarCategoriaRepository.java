package com.sulimann.cleanarch.infra.controllers.categoria.criar;

import org.springframework.stereotype.Component;

import com.sulimann.cleanarch.core.usecases.categoria.criar.ICriarCategoriaRespository;
import com.sulimann.cleanarch.infra.entities.CategoriaEntity;
import com.sulimann.cleanarch.infra.repositories.CategoriaRepository;

@Component
public class CriarCategoriaRepository implements ICriarCategoriaRespository<CategoriaEntity>{

  private final CategoriaRepository repository;

  public CriarCategoriaRepository(CategoriaRepository repository) {
    this.repository = repository;
  }

  @Override
  public CategoriaEntity salvar(CategoriaEntity entity) {
    return this.repository.save(entity);
  }

  @Override
  public boolean existsByNome(String nome) {
    return this.repository.existsByNome(nome);
  }

}
