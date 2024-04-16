package com.sulimann.cleanarch.infra.controllers.pais.criar;

import com.sulimann.cleanarch.core.constants.ErrorMessage;
import com.sulimann.cleanarch.core.usecases.pais.criar.ICriarPaisRequest;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CriarPaisRequest implements ICriarPaisRequest{

  @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
  private String nome;

}
