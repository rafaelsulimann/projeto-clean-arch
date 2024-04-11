package com.sulimann.cleanarch.core.usecases.livro.criar;

import java.util.Optional;

import com.sulimann.cleanarch.core.domain.entities.IAutor;

public interface ICriarLivroAutorRepository<AutorEntity extends IAutor> {

  Optional<AutorEntity> findById(Long autor);

}
