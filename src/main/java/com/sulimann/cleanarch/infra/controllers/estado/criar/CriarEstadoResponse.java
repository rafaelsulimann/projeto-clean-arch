package com.sulimann.cleanarch.infra.controllers.estado.criar;

import com.sulimann.cleanarch.core.usecases.estado.criar.ICriarEstadoResponse;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CriarEstadoResponse implements ICriarEstadoResponse{

  private Long id;
  private String nome;
  private CriarEstadoPaisResponse pais;

}
