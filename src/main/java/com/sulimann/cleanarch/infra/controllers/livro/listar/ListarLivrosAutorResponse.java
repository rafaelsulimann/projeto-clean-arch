package com.sulimann.cleanarch.infra.controllers.livro.listar;

import com.sulimann.cleanarch.core.usecases.livro.listar.IListarLivrosAutorResponse;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ListarLivrosAutorResponse implements IListarLivrosAutorResponse{
  private Long id;
  private String nome;
}
