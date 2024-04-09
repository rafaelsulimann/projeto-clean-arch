package com.sulimann.cleanarch.core.usecases.autor.criar;

import com.sulimann.cleanarch.domain.entities.IAutor;

public abstract class ACriarAutorUseCase<T extends IAutor> {

  private final ICriarAutorMapper<T> mapper;
  private final ICriarAutorRepository<T> repository;

  public ACriarAutorUseCase(ICriarAutorMapper<T> mapper, ICriarAutorRepository<T> repository) {
    this.mapper = mapper;
    this.repository = repository;
  }

  public ICriarAutorResponse execute(ICriarAutorRequest request){
    T entity = this.mapper.toEntity(request);
    entity = this.repository.salvar(entity);
    return this.mapper.toResponse(entity);
  }

}
