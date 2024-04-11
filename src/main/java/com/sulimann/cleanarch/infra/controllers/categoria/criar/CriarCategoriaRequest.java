package com.sulimann.cleanarch.infra.controllers.categoria.criar;

import com.sulimann.cleanarch.core.constants.ErrorMessage;
import com.sulimann.cleanarch.core.usecases.categoria.criar.ICriarCategoriaRequest;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CriarCategoriaRequest implements ICriarCategoriaRequest{

  @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
  private String nome;

}
