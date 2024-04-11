package com.sulimann.cleanarch.core.usecases.livro.criar;

import com.sulimann.cleanarch.domain.entities.IAutor;
import com.sulimann.cleanarch.domain.entities.ICategoria;
import com.sulimann.cleanarch.domain.entities.ILivro;

public interface ICriarLivroMapper<LivroEntity extends ILivro, CategoriaEntity extends ICategoria, AutorEntity extends IAutor> {

  LivroEntity toEntity(ICriarLivroRequest request, CategoriaEntity categoria, AutorEntity autor);
  ICriarLivroResponse toResponse(LivroEntity livro);

}
