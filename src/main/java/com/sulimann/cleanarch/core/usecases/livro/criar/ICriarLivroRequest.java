package com.sulimann.cleanarch.core.usecases.livro.criar;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface ICriarLivroRequest {
  String getTitulo();
  String getResumo();
  String getSumario();
  BigDecimal getPreco();
  Integer getNumeroPaginas();
  Long getIsbn();
  LocalDate getDataPublicacao();
  Long getCategoria();
  Long getAutor();
}
