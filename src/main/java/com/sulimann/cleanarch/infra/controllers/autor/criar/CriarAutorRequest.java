package com.sulimann.cleanarch.infra.controllers.autor.criar;

import com.sulimann.cleanarch.core.constants.ErrorMessage;
import com.sulimann.cleanarch.core.usecases.autor.criar.ICriarAutorRequest;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CriarAutorRequest implements ICriarAutorRequest{

  @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
  private String nome;

  @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
  @Email(message = ErrorMessage.EMAIL_INVALIDO)
  private String email;

  @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
  @Size(max = 400, message = ErrorMessage.DESCRICAO_MAXIMA_400)
  private String descricao;

}
