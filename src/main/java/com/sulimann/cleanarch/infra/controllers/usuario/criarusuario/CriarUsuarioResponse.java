package com.sulimann.cleanarch.infra.controllers.usuario.criarusuario;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sulimann.cleanarch.core.usecases.usuario.criarusuario.ICriarUsuarioResponse;
import com.sulimann.cleanarch.domain.enums.TipoUsuario;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CriarUsuarioResponse implements ICriarUsuarioResponse{

  private Long id;
  private String nome;
  private String email;
  private String documento;
  private TipoUsuario tipo;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
  private LocalDateTime dataCriacao;

}
