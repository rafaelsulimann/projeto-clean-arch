package com.sulimann.cleanarch.core.usecases.usuario.criarusuario;

import com.sulimann.cleanarch.domain.entities.IUsuario;

public interface ICriarUsuarioMapper<T extends IUsuario> {

  T toEntity(ICriarUsuarioRequest request);
  ICriarUsuarioResponse toResponse(T entity);

}
