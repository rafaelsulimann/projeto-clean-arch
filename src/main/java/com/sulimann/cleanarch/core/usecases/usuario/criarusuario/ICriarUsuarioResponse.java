package com.sulimann.cleanarch.core.usecases.usuario.criarusuario;

import java.time.LocalDateTime;

import com.sulimann.cleanarch.domain.enums.TipoUsuario;

public interface ICriarUsuarioResponse {

  Long getId();
  String getNome();
  String getEmail();
  String getDocumento();
  TipoUsuario getTipo();
  LocalDateTime getDataCriacao();

}
