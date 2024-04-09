package com.sulimann.cleanarch.infra.controllers.categoria.criar;

import org.springframework.stereotype.Component;

import com.sulimann.cleanarch.core.usecases.categoria.criar.ACriarCategoriaUseCase;
import com.sulimann.cleanarch.infra.entities.CategoriaEntity;

@Component
public class CriarCategoriaUseCase extends ACriarCategoriaUseCase<CategoriaEntity> {

  protected CriarCategoriaUseCase(CriarCategoriaMapper mapper, CriarCategoriaRepository repository) {
    super(mapper, repository);
  }

}
