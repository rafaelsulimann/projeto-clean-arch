package com.sulimann.cleanarch.infra.controllers.pais.criar;

import org.springframework.stereotype.Component;

import com.sulimann.cleanarch.core.usecases.pais.criar.ICriarPaisMapper;
import com.sulimann.cleanarch.core.usecases.pais.criar.ICriarPaisRequest;
import com.sulimann.cleanarch.core.usecases.pais.criar.ICriarPaisResponse;
import com.sulimann.cleanarch.infra.entities.PaisEntity;

@Component
public class CriarPaisMapper implements ICriarPaisMapper<PaisEntity>{

  @Override
  public PaisEntity toEntity(ICriarPaisRequest request) {
    return new PaisEntity(request.getNome());
  }

  @Override
  public ICriarPaisResponse toResponse(PaisEntity entity) {
    return CriarPaisResponse.builder()
            .id(entity.getId())
            .nome(entity.getNome()).build();
  }

}
