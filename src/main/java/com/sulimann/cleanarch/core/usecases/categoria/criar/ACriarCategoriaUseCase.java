package com.sulimann.cleanarch.core.usecases.categoria.criar;

import com.sulimann.cleanarch.domain.entities.ICategoria;

public abstract class ACriarCategoriaUseCase<T extends ICategoria> {

  private final ICriarCategoriaMapper<T> mapper;
  private final ICriarCategoriaRespository<T> repository;

  protected ACriarCategoriaUseCase(ICriarCategoriaMapper<T> mapper, ICriarCategoriaRespository<T> repository) {
    this.mapper = mapper;
    this.repository = repository;
  }

  public ICriarCategoriaResponse execute(ICriarCategoriaRequest request){
    T entity = this.mapper.toEntity(request);
    entity = this.repository.salvar(entity);
    return this.mapper.toResponse(entity);
  }
}
