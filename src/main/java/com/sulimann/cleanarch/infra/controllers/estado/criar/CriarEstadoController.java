package com.sulimann.cleanarch.infra.controllers.estado.criar;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sulimann.cleanarch.core.constants.Path;
import com.sulimann.cleanarch.core.usecases.estado.criar.ICriarEstadoResponse;
import com.sulimann.cleanarch.core.utils.httpresponse.ErroResponse;
import com.sulimann.cleanarch.core.utils.httpresponse.Resultado;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = Path.ESTADO)
public class CriarEstadoController {

  private final CriarEstadoUseCase service;

  public CriarEstadoController(CriarEstadoUseCase service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<Object> criarEstado(@RequestBody @Valid CriarEstadoRequest request){
    Resultado<ICriarEstadoResponse, ErroResponse> resultado = this.service.execute(request);
    return resultado.isErro()
            ? ResponseEntity.status(resultado.getErro().getStatus()).body(resultado.getErro())
            : ResponseEntity.status(HttpStatus.CREATED).body(resultado.getSucesso());
  }



}
