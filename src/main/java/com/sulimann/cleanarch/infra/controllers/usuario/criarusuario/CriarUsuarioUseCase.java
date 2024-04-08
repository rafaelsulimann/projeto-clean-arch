package com.sulimann.cleanarch.infra.controllers.usuario.criarusuario;

import org.springframework.stereotype.Component;

import com.sulimann.cleanarch.core.usecases.usuario.criarusuario.ACriarUsuarioUseCase;
import com.sulimann.cleanarch.infra.entities.UsuarioEntity;

@Component
public class CriarUsuarioUseCase extends ACriarUsuarioUseCase<UsuarioEntity>{

  public CriarUsuarioUseCase(CriarUsuarioMapper criarUsuarioMapper, CriarUsuarioRepository criarUsuarioRepository) {
    super(criarUsuarioMapper, criarUsuarioRepository);
  }

}
