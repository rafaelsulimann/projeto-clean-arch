package com.sulimann.cleanarch.infra.controllers.livro.obterbyid;

import org.springframework.stereotype.Component;

import com.sulimann.cleanarch.core.usecases.livro.obterbyid.IObterLivroByIdMapper;
import com.sulimann.cleanarch.core.usecases.livro.obterbyid.IObterLivroByIdResponse;
import com.sulimann.cleanarch.infra.entities.LivroEntity;

@Component
public class ObterLivroByIdMapper implements IObterLivroByIdMapper<LivroEntity> {

  @Override
  public IObterLivroByIdResponse toResponse(LivroEntity livro) {
    return ObterLivroByIdResponse.builder()
        .id(livro.getId())
        .titulo(livro.getTitulo())
        .resumo(livro.getResumo())
        .sumario(livro.getSumario())
        .preco(livro.getPreco())
        .numeroPaginas(livro.getNumeroPaginas())
        .isbn(livro.getIsbn())
        .dataPublicacao(livro.getDataPublicacao())
        .categoria(ObterLivroByIdCategoriaResponse.builder()
            .id(livro.getCategoria().getId())
            .nome(livro.getCategoria().getNome()).build())
        .autor(ObterLivroByIdAutorResponse.builder()
            .id(livro.getAutor().getId())
            .nome(livro.getAutor().getNome()).build())
        .build();
  }
}
