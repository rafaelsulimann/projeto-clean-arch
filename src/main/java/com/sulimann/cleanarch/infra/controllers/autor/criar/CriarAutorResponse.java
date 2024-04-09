package com.sulimann.cleanarch.infra.controllers.autor.criar;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sulimann.cleanarch.core.usecases.autor.criar.ICriarAutorResponse;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CriarAutorResponse implements ICriarAutorResponse{

  private Long id;
  private String nome;
  private String email;
  private String descricao;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
  private LocalDateTime dataCriacao;

}
