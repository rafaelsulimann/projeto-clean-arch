package com.sulimann.cleanarch.infra.controllers.livros.criar;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.sulimann.cleanarch.core.usecases.livro.criar.ICriarLivroResponse;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CriarLivroResponse implements ICriarLivroResponse{

  private Long id;
  private String titulo;
  private String resumo;
  private String sumario;
  private BigDecimal preco;
  private Integer numeroPaginas;
  private Long isbn;
  private LocalDate dataPublicacao;
  private CriarLivroCategoriaResponse categoria;
  private CriarLivroAutorResponse autor;

}
