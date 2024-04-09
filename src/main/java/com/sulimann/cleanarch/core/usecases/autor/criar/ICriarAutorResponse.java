package com.sulimann.cleanarch.core.usecases.autor.criar;

import java.time.LocalDateTime;

public interface ICriarAutorResponse {

  Long getId();
  String getNome();
  String getEmail();
  String getDescricao();
  LocalDateTime getDataCriacao();

}
