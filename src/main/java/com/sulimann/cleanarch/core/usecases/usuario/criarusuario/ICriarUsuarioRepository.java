package com.sulimann.cleanarch.core.usecases.usuario.criarusuario;

import com.sulimann.cleanarch.domain.entities.IUsuario;

public interface ICriarUsuarioRepository<T extends IUsuario> {

  T salvar(T entity);

}
