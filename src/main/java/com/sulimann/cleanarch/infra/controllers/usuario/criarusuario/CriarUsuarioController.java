package com.sulimann.cleanarch.infra.controllers.usuario.criarusuario;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sulimann.cleanarch.core.constants.Path;
import com.sulimann.cleanarch.core.usecases.usuario.criarusuario.ICriarUsuarioResponse;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = Path.USUARIO)
public class CriarUsuarioController {

  private CriarUsuarioUseCase service;

  public CriarUsuarioController(CriarUsuarioUseCase service) {
    this.service = service;
  }

  @PostMapping
  @Transactional
  public ResponseEntity<ICriarUsuarioResponse> criarUsuario(@RequestBody @Valid CriarUsuarioRequest request){
    return ResponseEntity.status(HttpStatus.CREATED).body(this.service.criarUsuario(request));
  }

}
