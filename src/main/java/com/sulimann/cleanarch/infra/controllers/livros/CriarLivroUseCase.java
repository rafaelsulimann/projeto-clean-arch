package com.sulimann.cleanarch.infra.controllers.livros;

import org.springframework.stereotype.Service;

import com.sulimann.cleanarch.core.usecases.livro.criar.ACriarLivroUseCase;
import com.sulimann.cleanarch.infra.entities.AutorEntity;
import com.sulimann.cleanarch.infra.entities.CategoriaEntity;
import com.sulimann.cleanarch.infra.entities.LivroEntity;

@Service
public class CriarLivroUseCase extends ACriarLivroUseCase<LivroEntity, CategoriaEntity, AutorEntity> {

  public CriarLivroUseCase(CriarLivroCategoriaRepository criarLivroCategoriaRepository,
      CriarLivroAutorRepository criarLivroAutorRepository, CriarLivroRepository repository,
      CriarLivroMapper mapper) {
    super(criarLivroCategoriaRepository, criarLivroAutorRepository, repository, mapper);
  }

}
