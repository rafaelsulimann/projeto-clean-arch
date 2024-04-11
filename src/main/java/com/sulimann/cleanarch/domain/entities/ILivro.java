package com.sulimann.cleanarch.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface ILivro {
  Long getId();
  String getTitulo();
  String getResumo();
  String getSumario();
  BigDecimal getPreco();
  Integer getNumeroPaginas();
  Long getIsbn();
  LocalDate getDataPublicacao();
  ICategoria getCategoria();
  IAutor getAutor();
}
