package com.sulimann.cleanarch.core.usecases.categoria.criar;

public interface ICriarCategoriaMapper<T> {

  T toEntity(ICriarCategoriaRequest request);
  ICriarCategoriaResponse toResponse(T entity);

}
