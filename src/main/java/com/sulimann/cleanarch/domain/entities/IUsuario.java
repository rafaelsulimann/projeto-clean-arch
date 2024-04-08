package com.sulimann.cleanarch.domain.entities;

import java.time.LocalDateTime;

import com.sulimann.cleanarch.domain.enums.TipoUsuario;

public interface IUsuario{
  Long getId();
  String getNome();
  String getEmail();
  String getDocumento();
  TipoUsuario getTipo();
  LocalDateTime getDataCriacao();
}
