package com.sulimann.cleanarch.infra.controllers.pais.criar;

import org.springframework.stereotype.Service;

import com.sulimann.cleanarch.core.usecases.pais.criar.ACriarPaisUseCase;
import com.sulimann.cleanarch.infra.entities.PaisEntity;

@Service
public class CriarPaisUseCase extends ACriarPaisUseCase<PaisEntity>{

  protected CriarPaisUseCase(CriarPaisRepository repository, CriarPaisMapper mapper) {
    super(repository, mapper);
  }

}
