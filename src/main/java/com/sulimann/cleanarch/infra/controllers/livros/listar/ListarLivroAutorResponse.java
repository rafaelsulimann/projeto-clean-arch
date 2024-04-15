package com.sulimann.cleanarch.infra.controllers.livros.listar;

import com.sulimann.cleanarch.core.usecases.livro.listar.IListarLivroAutorResponse;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ListarLivroAutorResponse implements IListarLivroAutorResponse{
  private Long id;
  private String nome;
}
