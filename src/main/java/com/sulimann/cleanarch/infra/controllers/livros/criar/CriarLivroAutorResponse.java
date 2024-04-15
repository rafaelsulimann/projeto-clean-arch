package com.sulimann.cleanarch.infra.controllers.livros.criar;

import com.sulimann.cleanarch.core.usecases.livro.criar.ICriarLivroAutorResponse;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CriarLivroAutorResponse implements ICriarLivroAutorResponse{

  private Long id;
  private String nome;

}
