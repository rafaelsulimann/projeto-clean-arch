package com.sulimann.cleanarch.infra.controllers.livro.listar;

import org.springframework.data.jpa.domain.Specification;

import com.sulimann.cleanarch.infra.entities.LivroEntity;

import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@And({
  @Spec(path = "titulo", spec = LikeIgnoreCase.class),
  @Spec(path = "resumo", spec = LikeIgnoreCase.class),
  @Spec(path = "isbn", spec = Equal.class),
  @Spec(path = "dataPublicacao", spec = Equal.class),
})
public interface ListarLivrosSpec extends Specification<LivroEntity>{}
