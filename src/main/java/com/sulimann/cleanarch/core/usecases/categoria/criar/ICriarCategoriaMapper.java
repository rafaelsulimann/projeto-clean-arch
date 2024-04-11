package com.sulimann.cleanarch.core.usecases.categoria.criar;

import com.sulimann.cleanarch.domain.entities.ICategoria;

public interface ICriarCategoriaMapper<CategoriaEntity extends ICategoria> {

  CategoriaEntity toEntity(ICriarCategoriaRequest request);
  ICriarCategoriaResponse toResponse(CategoriaEntity entity);

}
