package com.sulimann.cleanarch.infra.controllers.livros.listar;

import com.sulimann.cleanarch.core.usecases.livro.listar.IListarLivroCategoriaResponse;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ListarLivroCategoriaResponse implements IListarLivroCategoriaResponse{

  private Long id;
  private String nome;

}
