package com.sulimann.cleanarch.core.usecases.categoria.criar;

import com.sulimann.cleanarch.core.domain.entities.ICategoria;

public interface ICriarCategoriaRespository<CategoriaEntity extends ICategoria> {

  CategoriaEntity salvar(CategoriaEntity entity);
  boolean existsByNome(String nome);

}
