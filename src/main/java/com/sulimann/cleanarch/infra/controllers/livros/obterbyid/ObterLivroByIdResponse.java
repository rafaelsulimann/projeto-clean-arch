package com.sulimann.cleanarch.infra.controllers.livros.obterbyid;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.sulimann.cleanarch.core.usecases.livro.obterbyid.IObterLivroByIdResponse;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ObterLivroByIdResponse implements IObterLivroByIdResponse{
  private Long id;
  private String titulo;
  private String resumo;
  private String sumario;
  private BigDecimal preco;
  private Integer numeroPaginas;
  private Long isbn;
  private LocalDate dataPublicacao;
  private ObterLivroByIdCategoriaResponse categoria;
  private ObterLivroByIdAutorResponse autor;
}
