package com.sulimann.cleanarch.infra.controllers.livro.obterbyid;

import org.springframework.stereotype.Service;

import com.sulimann.cleanarch.core.usecases.livro.obterbyid.AObterLivroByIdUseCase;
import com.sulimann.cleanarch.infra.entities.LivroEntity;

@Service
public class ObterLivroByIdUseCase extends AObterLivroByIdUseCase<LivroEntity>{

  public ObterLivroByIdUseCase(ObterLivroByIdRepository repository,
      ObterLivroByIdMapper mapper) {
    super(repository, mapper);
  }

}
