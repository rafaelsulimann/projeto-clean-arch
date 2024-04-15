package com.sulimann.cleanarch.infra.controllers.livros.listar;

import org.springframework.stereotype.Component;

import com.sulimann.cleanarch.core.usecases.livro.listar.IListarLivrosMapper;
import com.sulimann.cleanarch.core.usecases.livro.listar.IListarLivrosResponse;
import com.sulimann.cleanarch.infra.entities.LivroEntity;

@Component
public class ListarLivrosMapper implements IListarLivrosMapper<LivroEntity> {

  @Override
  public IListarLivrosResponse toResponse(LivroEntity livro) {
    return ListarLivrosResponse.builder()
        .id(livro.getId())
        .titulo(livro.getTitulo())
        .resumo(livro.getResumo())
        .sumario(livro.getSumario())
        .preco(livro.getPreco())
        .numeroPaginas(livro.getNumeroPaginas())
        .isbn(livro.getIsbn())
        .dataPublicacao(livro.getDataPublicacao())
        .categoria(ListarLivrosCategoriaResponse.builder()
            .id(livro.getCategoria().getId())
            .nome(livro.getCategoria().getNome()).build())
        .autor(ListarLivrosAutorResponse.builder()
            .id(livro.getAutor().getId())
            .nome(livro.getAutor().getNome()).build())
        .build();
  }
}
