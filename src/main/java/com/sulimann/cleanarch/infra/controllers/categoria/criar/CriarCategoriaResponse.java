package com.sulimann.cleanarch.infra.controllers.categoria.criar;

import com.sulimann.cleanarch.core.usecases.categoria.criar.ICriarCategoriaResponse;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CriarCategoriaResponse implements ICriarCategoriaResponse{

  private Long id;
  private String nome;

}
