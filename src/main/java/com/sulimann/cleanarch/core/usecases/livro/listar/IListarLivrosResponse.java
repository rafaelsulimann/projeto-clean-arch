package com.sulimann.cleanarch.core.usecases.livro.listar;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface IListarLivrosResponse {
  Long getId();
  String getTitulo();
  String getResumo();
  String getSumario();
  BigDecimal getPreco();
  Integer getNumeroPaginas();
  Long getIsbn();
  LocalDate getDataPublicacao();
  IListarLivrosCategoriaResponse getCategoria();
  IListarLivrosAutorResponse getAutor();
}
