package com.sulimann.cleanarch.core.usecases.categoria.criar;

import com.sulimann.cleanarch.domain.entities.ICategoria;

public abstract class ACriarCategoriaUseCase<CategoriaEntity extends ICategoria> {

  private final ICriarCategoriaMapper<CategoriaEntity> mapper;
  private final ICriarCategoriaRespository<CategoriaEntity> repository;

  protected ACriarCategoriaUseCase(ICriarCategoriaMapper<CategoriaEntity> mapper, ICriarCategoriaRespository<CategoriaEntity> repository) {
    this.mapper = mapper;
    this.repository = repository;
  }

  public ICriarCategoriaResponse execute(ICriarCategoriaRequest request){
    CategoriaEntity entity = this.mapper.toEntity(request);
    entity = this.repository.salvar(entity);
    return this.mapper.toResponse(entity);
  }
}
