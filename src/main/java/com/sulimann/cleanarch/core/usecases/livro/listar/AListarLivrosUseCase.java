package com.sulimann.cleanarch.core.usecases.livro.listar;

import com.sulimann.cleanarch.core.domain.entities.ILivro;
import com.sulimann.cleanarch.core.utils.page.IPage;
import com.sulimann.cleanarch.core.utils.page.IPageable;
import com.sulimann.cleanarch.core.utils.specification.ISpecification;

public abstract class AListarLivrosUseCase<LivroEntity extends ILivro> {

  private final IListarLivrosRepository<LivroEntity> repository;
  private final IListarLivrosMapper<LivroEntity> mapper;

  protected AListarLivrosUseCase(IListarLivrosRepository<LivroEntity> repository, IListarLivrosMapper<LivroEntity> mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  public IPage<IListarLivrosResponse> execute(ISpecification<LivroEntity> spec, IPageable pageable){
    IPage<LivroEntity> page = this.repository.listar(spec, pageable);
    return page.map(this.mapper::toResponse);
  }

}
