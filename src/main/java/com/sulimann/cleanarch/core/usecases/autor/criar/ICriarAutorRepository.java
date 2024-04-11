package com.sulimann.cleanarch.core.usecases.autor.criar;

import com.sulimann.cleanarch.domain.entities.IAutor;

public interface ICriarAutorRepository<AutorEntity extends IAutor> {

  AutorEntity salvar(AutorEntity entity);

}
