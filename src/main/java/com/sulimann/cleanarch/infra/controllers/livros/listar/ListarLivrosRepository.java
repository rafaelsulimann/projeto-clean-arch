package com.sulimann.cleanarch.infra.controllers.livros.listar;

import org.springframework.stereotype.Component;

import com.sulimann.cleanarch.core.usecases.livro.listar.IListarLivrosRepository;
import com.sulimann.cleanarch.core.utils.page.IPage;
import com.sulimann.cleanarch.core.utils.page.IPageable;
import com.sulimann.cleanarch.core.utils.specification.ISpecification;
import com.sulimann.cleanarch.infra.adapters.paginacao.PageWrapper;
import com.sulimann.cleanarch.infra.entities.LivroEntity;
import com.sulimann.cleanarch.infra.repositories.LivroRepository;

@Component
public class ListarLivrosRepository implements IListarLivrosRepository<LivroEntity>{

  private final LivroRepository repository;

  public ListarLivrosRepository(LivroRepository repository) {
    this.repository = repository;
  }

  @Override
  public IPage<LivroEntity> listar(ISpecification<LivroEntity> spec, IPageable pageable) {
    return new PageWrapper<>(this.repository.findAll(spec, pageable));
  }

}
