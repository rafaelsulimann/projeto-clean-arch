package com.sulimann.cleanarch.infra.controllers.livro.criar;

import org.springframework.stereotype.Component;

import com.sulimann.cleanarch.core.usecases.livro.criar.ICriarLivroMapper;
import com.sulimann.cleanarch.core.usecases.livro.criar.ICriarLivroRequest;
import com.sulimann.cleanarch.core.usecases.livro.criar.ICriarLivroResponse;
import com.sulimann.cleanarch.infra.entities.AutorEntity;
import com.sulimann.cleanarch.infra.entities.CategoriaEntity;
import com.sulimann.cleanarch.infra.entities.LivroEntity;

@Component
public class CriarLivroMapper implements ICriarLivroMapper<LivroEntity, CategoriaEntity, AutorEntity>{

  @Override
  public LivroEntity toEntity(ICriarLivroRequest request, CategoriaEntity categoria, AutorEntity autor) {
    return new LivroEntity(request.getTitulo(), request.getResumo(), request.getSumario(), request.getPreco(), request.getNumeroPaginas(), request.getIsbn(), request.getDataPublicacao(), categoria, autor);
  }

  @Override
  public ICriarLivroResponse toResponse(LivroEntity livro) {
    return CriarLivroResponse.builder()
            .id(livro.getId())
            .titulo(livro.getTitulo())
            .resumo(livro.getResumo())
            .sumario(livro.getSumario())
            .preco(livro.getPreco())
            .numeroPaginas(livro.getNumeroPaginas())
            .isbn(livro.getIsbn())
            .dataPublicacao(livro.getDataPublicacao())
            .categoria(CriarLivroCategoriaResponse.builder()
              .id(livro.getCategoria().getId())
              .nome(livro.getCategoria().getNome()).build()
            )
            .autor(CriarLivroAutorResponse.builder()
              .id(livro.getAutor().getId())
              .nome(livro.getAutor().getNome()).build()
            )
            .build();
  }

}
