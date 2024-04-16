package com.sulimann.cleanarch.infra.controllers.livro.obterbyid;

import com.sulimann.cleanarch.core.usecases.livro.obterbyid.IObterLivroByIdAutorResponse;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ObterLivroByIdAutorResponse implements IObterLivroByIdAutorResponse {
  private Long id;
  private String nome;
}
