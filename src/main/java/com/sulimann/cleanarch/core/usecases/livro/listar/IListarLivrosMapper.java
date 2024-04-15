package com.sulimann.cleanarch.core.usecases.livro.listar;

import com.sulimann.cleanarch.core.domain.entities.ILivro;

public interface IListarLivrosMapper<LivroEntity extends ILivro> {
  IListarLivrosResponse toResponse(LivroEntity entity);
}
