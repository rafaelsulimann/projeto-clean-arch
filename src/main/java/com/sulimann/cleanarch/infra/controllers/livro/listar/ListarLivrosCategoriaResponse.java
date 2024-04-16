package com.sulimann.cleanarch.infra.controllers.livro.listar;

import com.sulimann.cleanarch.core.usecases.livro.listar.IListarLivrosCategoriaResponse;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ListarLivrosCategoriaResponse implements IListarLivrosCategoriaResponse{

  private Long id;
  private String nome;

}
