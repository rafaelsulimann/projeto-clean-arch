package com.sulimann.cleanarch.core.usecases.autor.criar;

import com.sulimann.cleanarch.core.domain.entities.IAutor;

public interface ICriarAutorRepository<AutorEntity extends IAutor> {

  AutorEntity salvar(AutorEntity entity);
  boolean existsByEmail(String email);

}
