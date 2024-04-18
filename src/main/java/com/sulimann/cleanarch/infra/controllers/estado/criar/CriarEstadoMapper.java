package com.sulimann.cleanarch.infra.controllers.estado.criar;

import org.springframework.stereotype.Component;

import com.sulimann.cleanarch.core.usecases.estado.criar.ICriarEstadoMapper;
import com.sulimann.cleanarch.core.usecases.estado.criar.ICriarEstadoRequest;
import com.sulimann.cleanarch.core.usecases.estado.criar.ICriarEstadoResponse;
import com.sulimann.cleanarch.infra.entities.EstadoEntity;
import com.sulimann.cleanarch.infra.entities.PaisEntity;

@Component
public class CriarEstadoMapper implements ICriarEstadoMapper<EstadoEntity, PaisEntity>{

  @Override
  public EstadoEntity toEntity(ICriarEstadoRequest request, PaisEntity pais) {
    return new EstadoEntity(request.getNome(), pais);
  }

  @Override
  public ICriarEstadoResponse toResponse(EstadoEntity estado) {
    return CriarEstadoResponse.builder()
            .id(estado.getId())
            .nome(estado.getNome())
            .pais(CriarEstadoPaisResponse.builder()
                  .id(estado.getPais().getId())
                  .nome(estado.getPais().getNome()).build()
            ).build();
  }

}
