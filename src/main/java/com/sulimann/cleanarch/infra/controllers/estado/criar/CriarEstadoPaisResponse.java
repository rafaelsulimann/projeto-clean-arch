package com.sulimann.cleanarch.infra.controllers.estado.criar;

import com.sulimann.cleanarch.core.usecases.estado.criar.ICriarEstadoPaisResponse;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CriarEstadoPaisResponse implements ICriarEstadoPaisResponse{

  private Long id;
  private String nome;

}
