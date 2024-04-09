package com.sulimann.cleanarch.core.usecases.autor.criar;

public interface ICriarAutorRepository<T> {

  T salvar(T entity);

}
