package com.sulimann.cleanarch.infra.controllers.livro.obterbyid;

import com.sulimann.cleanarch.core.usecases.livro.obterbyid.IObterLivroByIdCategoriaResponse;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ObterLivroByIdCategoriaResponse implements IObterLivroByIdCategoriaResponse{
  private Long id;
  private String nome;
}
