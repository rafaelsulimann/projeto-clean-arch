package com.sulimann.cleanarch.infra.controllers.livro.criar;

import com.sulimann.cleanarch.core.usecases.livro.criar.ICriarLivroAutorResponse;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CriarLivroAutorResponse implements ICriarLivroAutorResponse{

  private Long id;
  private String nome;

}
