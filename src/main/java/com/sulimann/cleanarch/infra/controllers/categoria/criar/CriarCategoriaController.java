package com.sulimann.cleanarch.infra.controllers.categoria.criar;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sulimann.cleanarch.core.constants.Path;
import com.sulimann.cleanarch.core.usecases.categoria.criar.ICriarCategoriaResponse;
import com.sulimann.cleanarch.core.utils.httpresponse.ErroResponse;
import com.sulimann.cleanarch.core.utils.httpresponse.Resultado;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = Path.CATEGORIA)
public class CriarCategoriaController {

  private final CriarCategoriaUseCase service;

  public CriarCategoriaController(CriarCategoriaUseCase service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<Object> criarCategoria(@RequestBody @Valid CriarCategoriaRequest request){
    Resultado<ICriarCategoriaResponse, ErroResponse> resultado = this.service.execute(request);
    return resultado.isErro()
            ? ResponseEntity.status(resultado.getErro().getStatus()).body(resultado.getErro())
            : ResponseEntity.status(HttpStatus.CREATED).body(resultado.getSucesso());
  }

}
