package com.sulimann.cleanarch.core.usecases.autor.criar;

public interface ICriarAutorMapper<T> {

  T toEntity(ICriarAutorRequest request);
  ICriarAutorResponse toResponse(T entity);

}
