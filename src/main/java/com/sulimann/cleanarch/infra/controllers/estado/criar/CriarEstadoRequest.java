package com.sulimann.cleanarch.infra.controllers.estado.criar;

import com.sulimann.cleanarch.core.constants.ErrorMessage;
import com.sulimann.cleanarch.core.usecases.estado.criar.ICriarEstadoRequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CriarEstadoRequest implements ICriarEstadoRequest{

  @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
  private String nome;

  @NotNull(message = ErrorMessage.CAMPO_OBRIGATORIO)
  private Long paisId;

}
