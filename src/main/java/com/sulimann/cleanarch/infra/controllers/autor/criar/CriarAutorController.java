package com.sulimann.cleanarch.infra.controllers.autor.criar;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sulimann.cleanarch.core.constants.Path;
import com.sulimann.cleanarch.core.usecases.autor.criar.ICriarAutorResponse;
import com.sulimann.cleanarch.core.utils.httpresponse.ErroResponse;
import com.sulimann.cleanarch.core.utils.httpresponse.Resultado;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = Path.AUTOR)
public class CriarAutorController {

  private final CriarUsuarioUseCase service;

  public CriarAutorController(CriarUsuarioUseCase service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<Object> criarUsuario(@RequestBody @Valid CriarAutorRequest request){
    Resultado<ICriarAutorResponse, ErroResponse> resultado = this.service.execute(request);
    return resultado.isErro()
            ? ResponseEntity.status(resultado.getErro().getStatus()).body(resultado.getErro())
            : ResponseEntity.status(HttpStatus.CREATED).body(resultado.getSucesso());
  }

}
