package com.sulimann.cleanarch.core.usecases.autor.criar;

import com.sulimann.cleanarch.domain.entities.IAutor;

import jakarta.transaction.Transactional;

public abstract class ACriarAutorUseCase<AutorEntity extends IAutor> {

  private final ICriarAutorMapper<AutorEntity> mapper;
  private final ICriarAutorRepository<AutorEntity> repository;

  protected ACriarAutorUseCase(ICriarAutorMapper<AutorEntity> mapper, ICriarAutorRepository<AutorEntity> repository) {
    this.mapper = mapper;
    this.repository = repository;
  }

  @Transactional
  public ICriarAutorResponse execute(ICriarAutorRequest request){
    AutorEntity entity = this.mapper.toEntity(request);
    entity = this.repository.salvar(entity);
    return this.mapper.toResponse(entity);
  }

}
