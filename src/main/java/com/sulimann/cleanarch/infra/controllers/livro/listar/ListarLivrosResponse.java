package com.sulimann.cleanarch.infra.controllers.livro.listar;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.sulimann.cleanarch.core.usecases.livro.listar.IListarLivrosResponse;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ListarLivrosResponse implements IListarLivrosResponse{

  private Long id;
  private String titulo;
  private String resumo;
  private String sumario;
  private BigDecimal preco;
  private Integer numeroPaginas;
  private Long isbn;
  private LocalDate dataPublicacao;
  private ListarLivrosCategoriaResponse categoria;
  private ListarLivrosAutorResponse autor;

}
