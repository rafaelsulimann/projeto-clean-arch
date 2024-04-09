package com.sulimann.cleanarch.infra.controllers.categoria.criar;

import com.sulimann.cleanarch.core.constants.ErrorMessage;
import com.sulimann.cleanarch.core.usecases.categoria.criar.ICriarCategoriaRequest;
import com.sulimann.cleanarch.infra.entities.CategoriaEntity;
import com.sulimann.cleanarch.infra.utils.validators.uniquevalue.UniqueValue;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CriarCategoriaRequest implements ICriarCategoriaRequest{

  @NotBlank(message = ErrorMessage.CAMPO_OBRIGATORIO)
  @UniqueValue(domainClass = CategoriaEntity.class, fieldName = "nome", message = "Nome já existente")
  private String nome;

}
