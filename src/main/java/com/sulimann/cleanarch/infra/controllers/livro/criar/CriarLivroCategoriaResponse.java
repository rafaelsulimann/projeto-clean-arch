package com.sulimann.cleanarch.infra.controllers.livro.criar;

import com.sulimann.cleanarch.core.usecases.livro.criar.ICriarLivroCategoriaResponse;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CriarLivroCategoriaResponse implements ICriarLivroCategoriaResponse{

  private Long id;
  private String nome;

}
