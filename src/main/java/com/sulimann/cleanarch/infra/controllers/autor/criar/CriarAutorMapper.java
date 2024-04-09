package com.sulimann.cleanarch.infra.controllers.autor.criar;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.stereotype.Component;

import com.sulimann.cleanarch.core.usecases.autor.criar.ICriarAutorMapper;
import com.sulimann.cleanarch.core.usecases.autor.criar.ICriarAutorRequest;
import com.sulimann.cleanarch.core.usecases.autor.criar.ICriarAutorResponse;
import com.sulimann.cleanarch.infra.entities.AutorEntity;

@Component
public class CriarAutorMapper implements ICriarAutorMapper<AutorEntity>{

  @Override
  public AutorEntity toEntity(ICriarAutorRequest request) {
    return new AutorEntity(request.getNome(), request.getEmail(), request.getDescricao(), LocalDateTime.now(ZoneId.of("UTC")));
  }

  @Override
  public ICriarAutorResponse toResponse(AutorEntity entity) {
    return CriarAutorResponse.builder()
            .id(entity.getId())
            .nome(entity.getDescricao())
            .email(entity.getEmail())
            .descricao(entity.getDescricao())
            .dataCriacao(entity.getDataCriacao())
            .build();
  }

}
