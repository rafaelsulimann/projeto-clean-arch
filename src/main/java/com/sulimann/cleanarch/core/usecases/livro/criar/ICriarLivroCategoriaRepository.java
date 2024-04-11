package com.sulimann.cleanarch.core.usecases.livro.criar;

import java.util.Optional;

import com.sulimann.cleanarch.core.domain.entities.ICategoria;

public interface ICriarLivroCategoriaRepository<CategoriaEntity extends ICategoria> {

  Optional<CategoriaEntity> findById(Long categoria);

}
