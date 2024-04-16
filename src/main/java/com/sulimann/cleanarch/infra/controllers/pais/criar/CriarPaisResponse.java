package com.sulimann.cleanarch.infra.controllers.pais.criar;

import com.sulimann.cleanarch.core.usecases.pais.criar.ICriarPaisResponse;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CriarPaisResponse implements ICriarPaisResponse{

  private Long id;
  private String nome;

}
