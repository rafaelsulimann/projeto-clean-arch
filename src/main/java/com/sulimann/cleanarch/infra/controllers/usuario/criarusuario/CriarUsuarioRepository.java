package com.sulimann.cleanarch.infra.controllers.usuario.criarusuario;

import org.springframework.stereotype.Component;

import com.sulimann.cleanarch.core.usecases.usuario.criarusuario.ICriarUsuarioRepository;
import com.sulimann.cleanarch.infra.entities.UsuarioEntity;
import com.sulimann.cleanarch.infra.repositories.UsuarioRepository;

@Component
public class CriarUsuarioRepository implements ICriarUsuarioRepository<UsuarioEntity>{

  private final UsuarioRepository usuarioRepository;

  public CriarUsuarioRepository(UsuarioRepository usuarioRepository) {
    this.usuarioRepository = usuarioRepository;
  }

  @Override
  public UsuarioEntity salvar(UsuarioEntity entity) {
    return this.usuarioRepository.save(entity);
  }

}
