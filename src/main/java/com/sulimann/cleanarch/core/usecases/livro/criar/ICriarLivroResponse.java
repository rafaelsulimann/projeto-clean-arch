package com.sulimann.cleanarch.core.usecases.livro.criar;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface ICriarLivroResponse {
  Long getId();
  String getTitulo();
  String getResumo();
  String getSumario();
  BigDecimal getPreco();
  Integer getNumeroPaginas();
  Long getIsbn();
  LocalDate getDataPublicacao();
  ICriarLivroCategoriaResponse getCategoria();
  ICriarLivroAutorResponse getAutor();
}
