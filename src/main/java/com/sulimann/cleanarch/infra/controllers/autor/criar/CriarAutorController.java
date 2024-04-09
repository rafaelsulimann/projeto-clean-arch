package com.sulimann.cleanarch.infra.controllers.autor.criar;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sulimann.cleanarch.core.constants.Path;
import com.sulimann.cleanarch.core.usecases.autor.criar.ICriarAutorResponse;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = Path.AUTOR)
public class CriarAutorController {

  private final CriarUsuarioUseCase service;

  public CriarAutorController(CriarUsuarioUseCase service) {
    this.service = service;
  }

  @PostMapping
  @Transactional
  public ResponseEntity<ICriarAutorResponse> criarUsuario(@RequestBody @Valid CriarAutorRequest request){
    return ResponseEntity.status(HttpStatus.CREATED).body(this.service.execute(request));
  }

}
