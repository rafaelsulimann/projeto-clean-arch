package com.sulimann.cleanarch.core.usecases.livro.obterbyid;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface IObterLivroByIdResponse {
  Long getId();
  String getTitulo();
  String getResumo();
  String getSumario();
  BigDecimal getPreco();
  Integer getNumeroPaginas();
  Long getIsbn();
  LocalDate getDataPublicacao();
  IObterLivroByIdCategoriaResponse getCategoria();
  IObterLivroByIdAutorResponse getAutor();
}
