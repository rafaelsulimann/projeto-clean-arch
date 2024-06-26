package com.sulimann.cleanarch.core.domain.entities;

import java.time.LocalDateTime;

public interface IAutor {
  Long getId();
  String getNome();
  String getEmail();
  String getDescricao();
  LocalDateTime getDataCriacao();
}
