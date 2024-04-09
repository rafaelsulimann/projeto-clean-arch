package com.sulimann.cleanarch.infra.controllers.categoria.criar;

import org.springframework.stereotype.Component;

import com.sulimann.cleanarch.core.usecases.categoria.criar.ICriarCategoriaMapper;
import com.sulimann.cleanarch.core.usecases.categoria.criar.ICriarCategoriaRequest;
import com.sulimann.cleanarch.core.usecases.categoria.criar.ICriarCategoriaResponse;
import com.sulimann.cleanarch.infra.entities.CategoriaEntity;

@Component
public class CriarCategoriaMapper implements ICriarCategoriaMapper<CategoriaEntity>{

  @Override
  public CategoriaEntity toEntity(ICriarCategoriaRequest request) {
    return new CategoriaEntity(request.getNome());
  }

  @Override
  public ICriarCategoriaResponse toResponse(CategoriaEntity entity) {
    return CriarCategoriaResponse.builder()
            .id(entity.getId())
            .nome(entity.getNome())
            .build();
  }

}
