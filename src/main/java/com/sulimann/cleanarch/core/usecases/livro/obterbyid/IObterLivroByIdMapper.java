package com.sulimann.cleanarch.core.usecases.livro.obterbyid;

import com.sulimann.cleanarch.core.domain.entities.ILivro;

public interface IObterLivroByIdMapper<LivroEntity extends ILivro> {

  IObterLivroByIdResponse toResponse(LivroEntity livro);

}
