package com.sulimann.cleanarch.core.usecases.livro.criar;

import com.sulimann.cleanarch.core.domain.entities.ILivro;

public interface ICriarLivroRepository<LivroEntity extends ILivro> {

  LivroEntity salvar(LivroEntity livro);
  boolean existsByTitulo(String titulo);
  boolean existsByIsbn(Long isbn);

}
