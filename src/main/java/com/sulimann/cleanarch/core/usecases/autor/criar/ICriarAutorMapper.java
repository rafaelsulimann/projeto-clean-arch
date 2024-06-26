package com.sulimann.cleanarch.core.usecases.autor.criar;

import com.sulimann.cleanarch.core.domain.entities.IAutor;

public interface ICriarAutorMapper<AutorEntity extends IAutor> {

  AutorEntity toEntity(ICriarAutorRequest request);
  ICriarAutorResponse toResponse(AutorEntity entity);

}
