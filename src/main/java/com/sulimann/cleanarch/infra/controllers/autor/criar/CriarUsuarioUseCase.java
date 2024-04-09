package com.sulimann.cleanarch.infra.controllers.autor.criar;

import org.springframework.stereotype.Service;

import com.sulimann.cleanarch.core.usecases.autor.criar.ACriarAutorUseCase;
import com.sulimann.cleanarch.infra.entities.AutorEntity;

@Service
public class CriarUsuarioUseCase extends ACriarAutorUseCase<AutorEntity>{

  public CriarUsuarioUseCase(CriarAutorMapper mapper, CriarAutorRepository repository) {
    super(mapper, repository);
  }

}
