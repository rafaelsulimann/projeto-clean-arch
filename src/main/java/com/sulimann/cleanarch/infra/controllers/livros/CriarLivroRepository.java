package com.sulimann.cleanarch.infra.controllers.livros;

import org.springframework.stereotype.Component;

import com.sulimann.cleanarch.core.usecases.livro.criar.ICriarLivroRepository;
import com.sulimann.cleanarch.infra.entities.LivroEntity;
import com.sulimann.cleanarch.infra.repositories.LivroRepository;

@Component
public class CriarLivroRepository implements ICriarLivroRepository<LivroEntity>{

  private final LivroRepository repository;

  public CriarLivroRepository(LivroRepository repository) {
    this.repository = repository;
  }

  @Override
  public LivroEntity salvar(LivroEntity livro) {
    return this.repository.save(livro);
  }

  @Override
  public boolean existsByTitulo(String titulo) {
    return this.repository.existsByTitulo(titulo);
  }

  @Override
  public boolean existsByIsbn(Long isbn) {
    return this.repository.existsByIsbn(isbn);
  }

}
