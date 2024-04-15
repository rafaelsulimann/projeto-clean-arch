package com.sulimann.cleanarch.core.usecases.livro.listar;

import com.sulimann.cleanarch.core.domain.entities.ILivro;
import com.sulimann.cleanarch.core.utils.page.IPage;
import com.sulimann.cleanarch.core.utils.page.IPageable;
import com.sulimann.cleanarch.core.utils.specification.ISpecification;

public interface IListarLivrosRepository<LivroEntity extends ILivro> {
  IPage<LivroEntity> listar(ISpecification<LivroEntity> spec, IPageable pageable);
}
