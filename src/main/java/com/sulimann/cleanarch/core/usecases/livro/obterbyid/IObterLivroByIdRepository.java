package com.sulimann.cleanarch.core.usecases.livro.obterbyid;

import java.util.Optional;

import com.sulimann.cleanarch.core.domain.entities.ILivro;

public interface IObterLivroByIdRepository<LivroEntity extends ILivro> {

  Optional<LivroEntity> findById(Long id);

}
