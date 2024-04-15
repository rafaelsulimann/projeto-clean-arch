package com.sulimann.cleanarch.infra.controllers.livros.listar;

import org.springframework.stereotype.Component;

import com.sulimann.cleanarch.core.usecases.livro.listar.AListarLivrosUseCase;
import com.sulimann.cleanarch.infra.entities.LivroEntity;

@Component
public class ListarLivrosUseCase extends AListarLivrosUseCase<LivroEntity>{

  protected ListarLivrosUseCase(ListarLivrosRepository repository,
      ListarLivrosMapper mapper) {
    super(repository, mapper);
  }

}
